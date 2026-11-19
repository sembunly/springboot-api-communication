package com.bunlysem.hospital.service;

import com.bunlysem.hospital.dto.HealthcareResponse;
import com.bunlysem.hospital.entity.ReceivedPayload;
import com.bunlysem.hospital.repository.ReceivedPayloadRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class HealthcareReceiverService {

    private final ReceivedPayloadRepository repository;

    @Transactional
    public HealthcareResponse receive(JsonNode payload) {

        if (payload == null || !payload.isObject()
                || !payload.path("patient").isObject()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "A patient object is required"
            );
        }

        String patientCode = payload
                .path("patient")
                .path("code")
                .asText("");

        if (patientCode.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Patient code is required"
            );
        }

        ReceivedPayload entity = new ReceivedPayload();
        entity.setPatientCode(patientCode);
        entity.setPayload(payload);
        entity.setIsActive(1);

        ReceivedPayload saved = repository.saveAndFlush(entity);

        return new HealthcareResponse(
                true,
                "Healthcare payload received successfully",
                saved.getId(),
                saved.getPatientCode(),
                saved.getReceivedAt()
        );
    }
}

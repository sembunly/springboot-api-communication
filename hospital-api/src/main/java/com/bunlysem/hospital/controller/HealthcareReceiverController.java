package com.bunlysem.hospital.controller;

import com.bunlysem.hospital.dto.HealthcareResponse;
import com.bunlysem.hospital.service.HealthcareReceiverService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/healthcare")
@RequiredArgsConstructor
public class HealthcareReceiverController {

    private final HealthcareReceiverService service;

    @PostMapping("/receive")
    public ResponseEntity<HealthcareResponse> receive(
            @RequestBody JsonNode payload
    ) {
        HealthcareResponse response = service.receive(payload);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}

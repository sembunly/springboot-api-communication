package com.bunlysem.lis.service;

import com.bunlysem.lis.dto.PatientRequest;
import com.bunlysem.lis.entity.LisPatient;
import com.bunlysem.lis.repository.LisPatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LisPatientService {
    private final LisPatientRepository repository;

    public LisPatientService(LisPatientRepository repository) { this.repository = repository; }

    public LisPatient receive(PatientRequest request) {
        LisPatient patient = repository.findByHospitalPatientId(request.hospitalPatientId()).orElseGet(LisPatient::new);
        patient.setHospitalPatientId(request.hospitalPatientId());
        patient.setName(request.name());
        patient.setGender(request.gender());
        patient.setDateOfBirth(request.dateOfBirth());
        patient.setPhone(request.phone());
        patient.setIsActive(1);
        return repository.save(patient);
    }

    public List<LisPatient> findAll() { return repository.findByIsActive(1); }

    public LisPatient findActive(Long id) {
        return repository.findByIdAndIsActive(id, 1).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with ID: " + id));
    }

    public void softDelete(Long id) {
        LisPatient patient = findActive(id);
        patient.setIsActive(0);
        repository.save(patient);
    }
}

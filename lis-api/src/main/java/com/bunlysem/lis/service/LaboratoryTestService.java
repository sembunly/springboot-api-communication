package com.bunlysem.lis.service;

import com.bunlysem.lis.dto.LaboratoryTestRequest;
import com.bunlysem.lis.entity.LaboratoryTest;
import com.bunlysem.lis.repository.LaboratoryTestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LaboratoryTestService {
    private final LaboratoryTestRepository repository;
    private final LisPatientService patientService;

    public LaboratoryTestService(LaboratoryTestRepository repository, LisPatientService patientService) {
        this.repository = repository;
        this.patientService = patientService;
    }

    public LaboratoryTest create(LaboratoryTestRequest request) {
        LaboratoryTest test = new LaboratoryTest();
        test.setPatient(patientService.findActive(request.patientId()));
        test.setName(request.name());
        return repository.save(test);
    }

    public List<LaboratoryTest> findAll() { return repository.findByIsActive(1); }

    public LaboratoryTest findActive(Long id) {
        return repository.findByIdAndIsActive(id, 1).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Laboratory test not found with ID: " + id));
    }

    public void softDelete(Long id) {
        LaboratoryTest test = findActive(id);
        test.setIsActive(0);
        repository.save(test);
    }
}

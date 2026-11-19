package com.bunlysem.lis.service;

import com.bunlysem.lis.dto.LaboratoryResultRequest;
import com.bunlysem.lis.entity.LaboratoryResult;
import com.bunlysem.lis.repository.LaboratoryResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LaboratoryResultService {
    private final LaboratoryResultRepository repository;
    private final LaboratoryTestService testService;

    public LaboratoryResultService(LaboratoryResultRepository repository, LaboratoryTestService testService) {
        this.repository = repository;
        this.testService = testService;
    }

    public LaboratoryResult create(LaboratoryResultRequest request) {
        LaboratoryResult result = new LaboratoryResult();
        result.setLaboratoryTest(testService.findActive(request.laboratoryTestId()));
        result.setResultValue(request.resultValue());
        result.setUnit(request.unit());
        result.setReferenceRange(request.referenceRange());
        result.setReportedAt(request.reportedAt() == null ? LocalDateTime.now() : request.reportedAt());
        return repository.save(result);
    }

    public List<LaboratoryResult> findAll() { return repository.findByIsActive(1); }
}

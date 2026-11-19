package com.bunlysem.lis.dto;

import com.bunlysem.lis.entity.LaboratoryResult;
import java.time.LocalDateTime;

public record LaboratoryResultResponse(Long id, Long laboratoryTestId, String resultValue, String unit,
                                       String referenceRange, LocalDateTime reportedAt) {
    public static LaboratoryResultResponse from(LaboratoryResult result) {
        return new LaboratoryResultResponse(result.getId(), result.getLaboratoryTest().getId(),
                result.getResultValue(), result.getUnit(), result.getReferenceRange(), result.getReportedAt());
    }
}

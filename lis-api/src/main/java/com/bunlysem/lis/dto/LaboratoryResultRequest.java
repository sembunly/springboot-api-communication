package com.bunlysem.lis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LaboratoryResultRequest(
        @NotNull Long laboratoryTestId,
        @NotBlank String resultValue,
        String unit,
        String referenceRange,
        LocalDateTime reportedAt
) {
}

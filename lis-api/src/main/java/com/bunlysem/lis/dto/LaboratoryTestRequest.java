package com.bunlysem.lis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LaboratoryTestRequest(
        @NotNull Long patientId,
        @NotBlank String name
) {
}

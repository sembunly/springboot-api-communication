package com.bunlysem.lis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatientRequest(
        @NotNull Long hospitalPatientId,
        @NotBlank String name,
        String gender,
        LocalDate dateOfBirth,
        String phone
) {
}

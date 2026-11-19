package com.bunlysem.hospital.dto;

import java.time.LocalDateTime;

public record HealthcareResponse(
        boolean success,
        String message,
        Long id,
        String patientCode,
        LocalDateTime receivedAt
) {
}

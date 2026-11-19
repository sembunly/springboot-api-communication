package com.bunlysem.lis.dto;

import com.bunlysem.lis.entity.LaboratoryTest;

public record LaboratoryTestResponse(Long id, Long patientId, String name, String status) {
    public static LaboratoryTestResponse from(LaboratoryTest test) {
        return new LaboratoryTestResponse(test.getId(), test.getPatient().getId(), test.getName(), test.getStatus());
    }
}

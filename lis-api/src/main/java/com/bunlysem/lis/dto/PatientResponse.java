package com.bunlysem.lis.dto;

import com.bunlysem.lis.entity.LisPatient;
import java.time.LocalDate;

public record PatientResponse(Long id, Long hospitalPatientId, String name, String gender,
                              LocalDate dateOfBirth, String phone) {
    public static PatientResponse from(LisPatient patient) {
        return new PatientResponse(patient.getId(), patient.getHospitalPatientId(), patient.getName(),
                patient.getGender(), patient.getDateOfBirth(), patient.getPhone());
    }
}

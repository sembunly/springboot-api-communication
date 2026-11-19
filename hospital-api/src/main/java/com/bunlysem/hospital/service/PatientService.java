package com.bunlysem.hospital.service;

import com.bunlysem.hospital.dto.PatientRequest;
import com.bunlysem.hospital.entity.Patient;
import com.bunlysem.hospital.repository.PatientRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // CREATE
    public Patient createPatient(PatientRequest request) {
        Patient patient = new Patient();

        patient.setName(request.getName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPhone(request.getPhone());
        patient.setIsActive(1);

        return patientRepository.save(patient);
    }

    // GET ALL ACTIVE PATIENTS
    public List<Patient> getAllPatients() {
        return patientRepository.findByIsActive(1);
    }

    // GET ACTIVE PATIENT BY ID
    public Patient getPatientById(Long id) {
        return patientRepository.findByIdAndIsActive(id, 1)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Patient not found with ID: " + id
                ));
    }

    // UPDATE
    public Patient updatePatient(Long id, PatientRequest request) {
        Patient patient = getPatientById(id);

        patient.setName(request.getName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPhone(request.getPhone());

        return patientRepository.save(patient);
    }

    // SOFT DELETE
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);

        patient.setIsActive(0);

        patientRepository.save(patient);
    }
}

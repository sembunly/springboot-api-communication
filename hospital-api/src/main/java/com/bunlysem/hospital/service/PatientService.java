
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

    // Create Patient
    public Patient createPatient(PatientRequest request) {
        Patient patient = new Patient();

        patient.setName(request.getName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPhone(request.getPhone());

        return patientRepository.save(patient);
    }

    // Get All Patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get Patient By ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Patient not found with ID: " + id
                ));
    }

    // Update Patient
    public Patient updatePatient(Long id, PatientRequest request) {
        Patient patient = getPatientById(id);

        patient.setName(request.getName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setPhone(request.getPhone());

        return patientRepository.save(patient);
    }

    // Delete Patient
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}

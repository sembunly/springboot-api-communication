package com.bunlysem.hospital.controller;

import com.bunlysem.hospital.dto.PatientRequest;
import com.bunlysem.hospital.entity.Patient;
import com.bunlysem.hospital.service.PatientService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST: Create Patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(
            @Valid @RequestBody PatientRequest request) {

        Patient patient = patientService.createPatient(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    // GET: All Patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // GET: Patient By ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    // PUT: Update Patient
    @PutMapping("/{id}")
    public Patient updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {

        return patientService.updatePatient(id, request);
    }

    // DELETE: Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}

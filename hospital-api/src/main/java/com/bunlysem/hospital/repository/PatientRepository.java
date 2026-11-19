package com.bunlysem.hospital.repository;

import com.bunlysem.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByIsActive(Integer isActive);
    Optional<Patient> findByIdAndIsActive(Long id, Integer isActive);
}

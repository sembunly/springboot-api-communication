package com.bunlysem.lis.repository;

import com.bunlysem.lis.entity.LisPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LisPatientRepository extends JpaRepository<LisPatient, Long> {
    List<LisPatient> findByIsActive(Integer isActive);
    Optional<LisPatient> findByIdAndIsActive(Long id, Integer isActive);
    Optional<LisPatient> findByHospitalPatientId(Long hospitalPatientId);
}

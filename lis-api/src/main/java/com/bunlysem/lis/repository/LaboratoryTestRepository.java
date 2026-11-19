package com.bunlysem.lis.repository;

import com.bunlysem.lis.entity.LaboratoryTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaboratoryTestRepository extends JpaRepository<LaboratoryTest, Long> {
    List<LaboratoryTest> findByIsActive(Integer isActive);
    Optional<LaboratoryTest> findByIdAndIsActive(Long id, Integer isActive);
}

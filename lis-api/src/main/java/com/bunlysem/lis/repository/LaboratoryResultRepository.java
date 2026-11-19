package com.bunlysem.lis.repository;

import com.bunlysem.lis.entity.LaboratoryResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratoryResultRepository extends JpaRepository<LaboratoryResult, Long> {
    List<LaboratoryResult> findByIsActive(Integer isActive);
}

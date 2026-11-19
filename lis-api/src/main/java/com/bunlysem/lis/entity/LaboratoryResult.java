package com.bunlysem.lis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "laboratory_results")
public class LaboratoryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "laboratory_test_id", nullable = false)
    private LaboratoryTest laboratoryTest;

    @Column(name = "result_value", nullable = false)
    private String resultValue;

    private String unit;
    private String referenceRange;

    @Column(nullable = false)
    private LocalDateTime reportedAt;

    @Column(name = "is_active", nullable = false)
    private Integer isActive = 1;

    public Long getId() { return id; }
    public LaboratoryTest getLaboratoryTest() { return laboratoryTest; }
    public void setLaboratoryTest(LaboratoryTest laboratoryTest) { this.laboratoryTest = laboratoryTest; }
    public String getResultValue() { return resultValue; }
    public void setResultValue(String resultValue) { this.resultValue = resultValue; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public String getReferenceRange() { return referenceRange; }
    public void setReferenceRange(String referenceRange) { this.referenceRange = referenceRange; }
    public LocalDateTime getReportedAt() { return reportedAt; }
    public void setReportedAt(LocalDateTime reportedAt) { this.reportedAt = reportedAt; }
    public Integer getIsActive() { return isActive; }
    public void setIsActive(Integer isActive) { this.isActive = isActive; }
}

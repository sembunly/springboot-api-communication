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

@Entity
@Table(name = "laboratory_tests")
public class LaboratoryTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private LisPatient patient;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status = "ORDERED";

    @Column(name = "is_active", nullable = false)
    private Integer isActive = 1;

    public Long getId() { return id; }
    public LisPatient getPatient() { return patient; }
    public void setPatient(LisPatient patient) { this.patient = patient; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getIsActive() { return isActive; }
    public void setIsActive(Integer isActive) { this.isActive = isActive; }
}

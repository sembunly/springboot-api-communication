package com.bunlysem.lis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "lis_patients")
public class LisPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_patient_id", nullable = false, unique = true)
    private Long hospitalPatientId;

    @Column(nullable = false)
    private String name;

    private String gender;
    private LocalDate dateOfBirth;
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Integer isActive = 1;

    public Long getId() { return id; }
    public Long getHospitalPatientId() { return hospitalPatientId; }
    public void setHospitalPatientId(Long hospitalPatientId) { this.hospitalPatientId = hospitalPatientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getIsActive() { return isActive; }
    public void setIsActive(Integer isActive) { this.isActive = isActive; }
}

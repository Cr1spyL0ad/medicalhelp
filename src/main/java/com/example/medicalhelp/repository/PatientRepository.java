package com.example.medicalhelp.repository;

import com.example.medicalhelp.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    PatientModel findByUsername(String username);
}

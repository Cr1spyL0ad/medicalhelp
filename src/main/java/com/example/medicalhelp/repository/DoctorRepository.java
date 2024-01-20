package com.example.medicalhelp.repository;

import com.example.medicalhelp.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    List<DoctorModel> findAllBySpecialization(String specialization);
}

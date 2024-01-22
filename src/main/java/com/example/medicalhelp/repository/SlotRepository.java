package com.example.medicalhelp.repository;

import com.example.medicalhelp.model.SlotModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface SlotRepository extends JpaRepository<SlotModel, Long> {

    @Transactional
    void deleteAllByDoctorId(Long id);
    List<SlotModel> findAllByPatientIdAndTimeAfter(Long patientId, LocalDateTime dateTime);
    List<SlotModel> findAllByTimeBetweenAndDoctorId(LocalDateTime startingTime, LocalDateTime endingTime, Long doctorId);
}

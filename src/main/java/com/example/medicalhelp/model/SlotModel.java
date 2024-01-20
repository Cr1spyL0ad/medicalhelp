package com.example.medicalhelp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime time;

    @Transient
    private LocalDate unfinishedDate;
    @Transient
    private String unfinishedTime;

    public void setTime() {
        time = LocalDateTime.of(unfinishedDate, LocalTime.parse(unfinishedTime, DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public void reset(){
        id = null;
        patientId = null;
        doctorId = null;
        time = null;
        unfinishedTime = null;
        unfinishedDate = null;
    }
}

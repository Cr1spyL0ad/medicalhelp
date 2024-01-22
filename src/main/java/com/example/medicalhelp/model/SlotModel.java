package com.example.medicalhelp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Setter
    @Getter
    @ToString
    public static class SlotTable {
        private String name;
        private int cabinet;
        private String time;
        private long slotId;
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

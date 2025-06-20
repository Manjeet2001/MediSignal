package com.mediSignal.MediSignal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class HealthData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patient_id;

    private LocalDateTime timestamp;

    private Integer heartRate;

    private Integer systolic;
    private Integer diastolic;
}

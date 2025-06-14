package com.mediSignal.MediSignal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Threshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertType;
    private Integer minValue;
    private Integer maxValue;

    private Integer systolic;
    private Integer diastolic;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}

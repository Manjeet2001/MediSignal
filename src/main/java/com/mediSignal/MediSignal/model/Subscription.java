package com.mediSignal.MediSignal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long patientId;

    private String subscriberEmail;

    @ElementCollection
    private List<String> alertTypes;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Threshold> thresholds;
}

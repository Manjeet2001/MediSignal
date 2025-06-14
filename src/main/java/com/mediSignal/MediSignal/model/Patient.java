package com.mediSignal.MediSignal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "gender", nullable = false)
    private String Gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "contact", nullable = false)
    private String contact;

}

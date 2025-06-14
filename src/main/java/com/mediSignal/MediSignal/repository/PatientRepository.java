package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

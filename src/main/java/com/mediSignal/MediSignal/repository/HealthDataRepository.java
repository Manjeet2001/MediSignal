package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
}

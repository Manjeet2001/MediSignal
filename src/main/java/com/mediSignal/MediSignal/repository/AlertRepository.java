package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}

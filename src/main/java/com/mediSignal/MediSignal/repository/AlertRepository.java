package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByPatientIdOrderByTimestampDesc(Long patientId);

    List<Alert> findByPatientIdAndTypeAndTimestampBetween(Long patientId, String type, LocalDateTime start, LocalDateTime end);

    List<Alert> findByPatientIdAndType(Long patientId, String type);

    List<Alert> findByPatientIdAndTimestampBetween(Long patientId, LocalDateTime start, LocalDateTime end);
}

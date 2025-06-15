package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.DeliveryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryLogRepository extends JpaRepository<DeliveryLog, Long> {

    @Query("SELECT dl FROM DeliveryLog dl " +
            "JOIN Alert a ON dl.alertId = a.id " +
            "JOIN Subscription s ON a.patientId = s.patientId " +
            "WHERE s.id = :subscriptionId " +
            "ORDER BY dl.timestamp DESC")
    List<DeliveryLog> findTop20BySubscriptionIdOrderByTimestampDesc(Long subscriptionId);
    List<DeliveryLog> findByAlertIdOrderByAttemptAsc(Long alertId);

}

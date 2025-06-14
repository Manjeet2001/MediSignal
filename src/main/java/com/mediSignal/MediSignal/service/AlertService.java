package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.Alert;
import com.mediSignal.MediSignal.model.DeliveryLog;
import com.mediSignal.MediSignal.model.HealthData;
import com.mediSignal.MediSignal.model.Subscription;
import com.mediSignal.MediSignal.repository.AlertRepository;
import com.mediSignal.MediSignal.repository.DeliveryLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertService {
    private static final Logger log = LoggerFactory.getLogger(AlertService.class);
    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private DeliveryLogRepository deliveryLogRepository;

    public void triggerAlert(HealthData data, String alertType, Subscription sub) {
        Alert alert = new Alert();
        alert.setPatientId(data.getPatient_id());
        alert.setType(alertType);
        alert.setTimestamp(LocalDateTime.now());
        alert.setStatus("Pending");

        switch (alertType) {
            case "heartRate":
                alert.setValue(String.format("%d", data.getHeartRate()));
                break;

            case "bloodPressure":
                alert.setValue(String.format("%d/%d", data.getSystolic(), data.getDiastolic()));
                break;
        }

        alert.setDeliveryMethod("email");
        Alert savedAlert = alertRepository.save(alert);

        DeliveryLog log = new DeliveryLog();
        log.setAlertId(savedAlert.getId());
        log.setAttempt(1);
        log.setTimestamp(LocalDateTime.now());
        log.setStatus("Success");
        log.setMethod("Email");
        log.setResponseCode(200);

        deliveryLogRepository.save(log);
    }
}

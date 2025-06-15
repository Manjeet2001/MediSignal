package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.Alert;
import com.mediSignal.MediSignal.model.DeliveryLog;
import com.mediSignal.MediSignal.repository.DeliveryLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RetryService {
    private static final Logger log = LoggerFactory.getLogger(RetryService.class);
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DeliveryLogRepository deliveryLogRepository;

    @Async
    public void retry(Alert alert, String recipient, int maxAttempts) {
        int attempt = 1;
        boolean success = false;
        while (attempt <= maxAttempts && !success) {
            success = notificationService.sendNotification(alert.getDeliveryMethod(), recipient,
                    "Alert: " + alert.getType() + "value = " + alert.getValue()
                    );
            DeliveryLog log = new DeliveryLog();
            log.setAlertId(alert.getId());
            log.setAttempt(attempt);
            log.setTimestamp(LocalDateTime.now());
            log.setStatus(success ? "success" : "Retry");
            log.setMethod(alert.getDeliveryMethod());
            log.setResponseCode(success ? 200 : 500);

            deliveryLogRepository.save(log);

            if(!success){
                try {
                    Thread.sleep((long) Math.pow(2, attempt) * 1000);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            attempt++;
        }
    }

}

package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.DeliveryLog;
import com.mediSignal.MediSignal.repository.DeliveryLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryLogService {

    private final DeliveryLogRepository deliveryLogRepository;

    public DeliveryLogService(DeliveryLogRepository deliveryLogRepository) {
        this.deliveryLogRepository = deliveryLogRepository;
    }

    public List<DeliveryLog> getLogsByAlertId(Long alertId) {
        return deliveryLogRepository.findByAlertIdOrderByAttemptAsc(alertId);
    }

    public List<DeliveryLog> getRecentLogsBySubscriptionId(Long subscriptionId) {
        return deliveryLogRepository.findTop20BySubscriptionIdOrderByTimestampDesc(subscriptionId);
    }
}

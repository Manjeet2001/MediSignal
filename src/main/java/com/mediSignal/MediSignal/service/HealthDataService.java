package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.HealthData;
import com.mediSignal.MediSignal.model.Subscription;
import com.mediSignal.MediSignal.model.Threshold;
import com.mediSignal.MediSignal.repository.HealthDataRepository;
import com.mediSignal.MediSignal.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class HealthDataService {
    @Autowired
    private HealthDataRepository healthDataRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private AlertService alertService;

    public HealthData ingestHealthData(HealthData data) {
        data.setTimestamp(LocalDateTime.now());
        HealthData savedData = healthDataRepository.save(data);

        List<Subscription> subscriptions = subscriptionRepository.findAll()
                .stream()
                .filter(sub -> Objects.equals(sub.getPatientId(), data.getPatient_id()))
                .toList();

        for (Subscription sub : subscriptions) {
            for (Threshold threshold : sub.getThresholds()) {
                boolean alertTriggered = false;

                switch (threshold.getAlertType()){
                    case "heartRate":
                        if (data.getHeartRate() != null && (data.getHeartRate() < threshold.getMinValue() ||
                        data.getHeartRate() > threshold.getMaxValue())){
                            alertTriggered = true;
                        }
                        break;
                    case "bloodPressure" :
                        if (data.getSystolic() != null && data.getDiastolic() != null &&
                                (data.getSystolic() > threshold.getSystolic() || data.getDiastolic() < threshold.getSystolic())
                        ) {
                            alertTriggered = true;
                        }
                        break;
                }
                if (alertTriggered){
                    alertService.triggerAlert(data, threshold.getAlertType(), sub);
                }
            }
        }
        return savedData;
    }
}

package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.Threshold;
import com.mediSignal.MediSignal.repository.ThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThresholdService {
    @Autowired
    private ThresholdRepository thresholdRepository;

    public List<Threshold> getThresholdsBySubscriptionId(Long subscriptionId) {
        return thresholdRepository.findBySubscriptionId(subscriptionId);
    }

    public Threshold saveThreshold(Threshold threshold) {
        return thresholdRepository.save(threshold);
    }

    public void deleteThreshold(Long id) {
        thresholdRepository.deleteById(id);
    }
}

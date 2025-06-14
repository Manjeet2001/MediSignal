package com.mediSignal.MediSignal.service;

import com.mediSignal.MediSignal.model.Subscription;
import com.mediSignal.MediSignal.model.Threshold;
import com.mediSignal.MediSignal.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        if(subscription.getThresholds() != null){
            for(Threshold threshold : subscription.getThresholds()){
                threshold.setSubscription(subscription);
            }
        }
        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription with id: " + id + "not found"));
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}

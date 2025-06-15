package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
    List<Threshold> findBySubscriptionId(Long subscriptionId);
}

package com.mediSignal.MediSignal.repository;

import com.mediSignal.MediSignal.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}

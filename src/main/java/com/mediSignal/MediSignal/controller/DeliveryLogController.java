package com.mediSignal.MediSignal.controller;

import com.mediSignal.MediSignal.model.DeliveryLog;
import com.mediSignal.MediSignal.service.DeliveryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class DeliveryLogController {
    @Autowired
    private DeliveryLogService deliveryLogService;

    @GetMapping("/alert/{alertId}")
    public ResponseEntity<List<DeliveryLog>> getLogsByAlertId(@PathVariable Long alertId) {
        return ResponseEntity.ok(deliveryLogService.getLogsByAlertId(alertId));
    }

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<List<DeliveryLog>> getRecentLogsBySubscriptionId(@PathVariable Long subscriptionId) {
        return ResponseEntity.ok(deliveryLogService.getRecentLogsBySubscriptionId(subscriptionId));
    }
}

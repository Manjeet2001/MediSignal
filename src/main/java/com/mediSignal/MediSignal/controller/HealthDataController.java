package com.mediSignal.MediSignal.controller;

import com.mediSignal.MediSignal.model.HealthData;
import com.mediSignal.MediSignal.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-data")
public class HealthDataController {
    @Autowired
    private HealthDataService healthDataService;

    @PostMapping
    public ResponseEntity<HealthData> ingestHealthData(@RequestBody HealthData data) {
        return ResponseEntity.ok(healthDataService.ingestHealthData(data));
    }
}

package com.mediSignal.MediSignal.controller;

import com.mediSignal.MediSignal.model.Alert;
import com.mediSignal.MediSignal.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Alert>> getAlertByPatientId(@PathVariable("patientId") Long patientId) {
        return ResponseEntity.ok(alertService.getAlertByPatientId(patientId));
    }


    @GetMapping("/patient/{patientId}/filter")
    public ResponseEntity<List<Alert>> getFilteredAlerts(
            @PathVariable Long patientId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ){
        return ResponseEntity.ok(alertService.getFilteredAlerts(patientId, type, startDate, endDate));
    }
    @GetMapping("/{alertId}")
    public ResponseEntity<Alert> getAlertByAlertId(@PathVariable("alertId") Long alertId) {
        return ResponseEntity.ok(alertService.getAlertByAlertId(alertId));
    }
}

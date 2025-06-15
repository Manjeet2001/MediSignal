package com.mediSignal.MediSignal.controller;

import com.mediSignal.MediSignal.service.DeliveryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("System is Up and running perfectly");
    }
}

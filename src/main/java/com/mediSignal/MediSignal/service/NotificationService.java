package com.mediSignal.MediSignal.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public boolean sendNotification(String method, String recipient, String message) {
        System.out.printf("sending %s to %s: %s%n", method, recipient, message);
        return Math.random() > 0.2;
    }
}

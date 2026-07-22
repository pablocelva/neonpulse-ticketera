package com.neonpulse.domain;

public interface MessageNotifier {
    void sendNotification(String destination, String message);    
}
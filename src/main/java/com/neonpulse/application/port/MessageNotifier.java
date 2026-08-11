package com.neonpulse.application.port;

public interface MessageNotifier {
    void sendNotification(String destination, String message);    
}
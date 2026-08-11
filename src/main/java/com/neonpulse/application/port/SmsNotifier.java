package com.neonpulse.application.port;

public interface SmsNotifier {
    public void sendMessage(String phoneNumber, String content); 
}

package com.neonpulse.domain;

public interface SmsNotifier {
    public void sendMessage(String phoneNumber, String content); 
}

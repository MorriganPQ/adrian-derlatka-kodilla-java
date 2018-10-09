package com.kodilla.good.patterns.challenges.order.service;

public class SmsInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending SMS to " + user.getPhone() + ":");
        System.out.println("\"Your order has been shipped\"");
    }
}

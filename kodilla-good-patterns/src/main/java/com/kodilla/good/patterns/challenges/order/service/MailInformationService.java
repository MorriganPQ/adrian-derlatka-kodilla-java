package com.kodilla.good.patterns.challenges.order.service;

public class MailInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending mail to " + user.getMail() + ":");
        System.out.println("\"Your order has been shipped\"");
    }
}

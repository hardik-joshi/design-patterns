package com.pluralsight.java.gettingstartedjunit5.patientintake.notifier;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmailNotifierTestDouble implements EmailNotifier {

    ArrayList<Message> receivedMessages = new ArrayList<>();

    @Override
    public void sendNotification(String subject, String body, String address) {
        this.receivedMessages.add(new Message(subject, body, address));
    }

    class Message {
        String toAddress;
        String subject;
        String body;

        public Message(String subject, String body, String address) {
            this.subject = subject;
            this.body = body;
            this.toAddress = address;
        }
    }
}
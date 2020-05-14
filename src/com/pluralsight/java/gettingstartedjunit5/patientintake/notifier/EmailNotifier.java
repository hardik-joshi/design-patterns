package com.pluralsight.java.gettingstartedjunit5.patientintake.notifier;

public interface EmailNotifier {
    void sendNotification(String subject, String body, String address);
}

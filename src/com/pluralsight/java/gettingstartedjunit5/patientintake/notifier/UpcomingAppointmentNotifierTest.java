package com.pluralsight.java.gettingstartedjunit5.patientintake.notifier;

import com.pluralsight.java.gettingstartedjunit5.patientintake.ClinicCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UpcomingAppointmentNotifierTest {
    private EmailNotifierTestDouble emailDouble;

    @BeforeEach
    void init() {
        emailDouble = new EmailNotifierTestDouble();
    }

    @Test
    void sendNotificationWithCorrectFormat() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.of(2020, 9,1));
        calendar.addAppointment("Jim","Weaver","avery", "09/02/2020 2:00 pm");
        UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar, emailDouble);
        notifier.run();

        assertEquals(1, emailDouble.receivedMessages.size());
        EmailNotifierTestDouble.Message expectedMessage = emailDouble.receivedMessages.get(0);
        assertAll(
                () -> assertEquals("weaverjim@mail.com", expectedMessage.toAddress),
                () -> assertEquals("Appointment Reminder", expectedMessage.subject),
                () -> assertEquals("You have an appointment tomorrow at 2:00 PM" +
                        " with Dr. Ralph Avery.", expectedMessage.body)
        );
    }
}
package com.pluralsight.java.gettingstartedjunit5.patientintake.notifier;

import com.pluralsight.java.gettingstartedjunit5.patientintake.ClinicCalendar;
import com.pluralsight.java.gettingstartedjunit5.patientintake.Doctor;
import com.pluralsight.java.gettingstartedjunit5.patientintake.PatientAppointment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UpcomingAppointmentNotifierTest {

    @Test
    void sendNotificationWithCorrectFormat() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.of(2020, 9,1));
        PatientAppointment appt = new PatientAppointment("Jim", "Weaver",
                LocalDateTime.of(2020,9,2,14,30), Doctor.avery);
        calendar.addAppointment("Jim","Weaver","avery", "09/02/2020 2:00 pm");
        UpcomingAppointmentNotifier notifier = new UpcomingAppointmentNotifier(calendar);
        notifier.run();
    }
}
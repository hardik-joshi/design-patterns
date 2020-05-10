package com.pluralsight.java.gettingstartedjunit5.patientintake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {

    @Test
    void allowEntryOfAnAppointment() {
        ClinicCalendar clinicCalendar = new ClinicCalendar(LocalDate.now());
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2020 02:00 pm");
        List<PatientAppointment> appointments = clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment enteredAppt = appointments.get(0);
        assertEquals("Jim", enteredAppt.getPatientFirstName());
        assertEquals("Weaver", enteredAppt.getPatientLastName());
        assertSame(Doctor.avery, enteredAppt.getDoctor());
        assertEquals("9/1/2020 02:00 PM",
                enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }

    @Test
    void returnTrueForHasAppointmentsIfThereAreAppointments() {
        ClinicCalendar clinicCalendar = new ClinicCalendar(LocalDate.now());
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2020 02:00 pm");
        assertTrue(clinicCalendar.hasAppointment(LocalDate.of(2020, 9, 1)));
    }

    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
        ClinicCalendar clinicCalendar = new ClinicCalendar(LocalDate.now());
        assertFalse(clinicCalendar.hasAppointment(LocalDate.of(2020, 9, 1)));
    }

    @Test
    void returnCurrentDaysAppointment() {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        calendar.addAppointment("Hardik", "Joshi", "avery",
                "05/10/2020 11:00 AM");
        calendar.addAppointment("Bhavesh", "Patel", "avery",
                "05/10/2020 11:30 AM");
        assertEquals(2, calendar.getTodayAppointments().size());
    }
}
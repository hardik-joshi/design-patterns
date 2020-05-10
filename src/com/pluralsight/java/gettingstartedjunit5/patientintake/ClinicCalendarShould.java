package com.pluralsight.java.gettingstartedjunit5.patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {

    @Test
    public void allowEntryOfAnAppointment() {
        ClinicCalendar clinicCalendar = new ClinicCalendar();
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2020 02:00 pm");
        List<PatientAppointment> appointments = clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment enteredAppt = appointments.get(0);
        assertEquals("Jim", enteredAppt.getPatientFirstName());
        assertEquals("Weaver", enteredAppt.getPatientLastName());
        assertEquals(Doctor.avery, enteredAppt.getDoctor());
        assertEquals("9/1/2020 02:00 PM",
                enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }
}
package com.pluralsight.java.gettingstartedjunit5.patientintake;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {
    private ClinicCalendar calendar;

    @BeforeEach
    void init() {
        calendar = new ClinicCalendar(LocalDate.of(2020, 9, 1));
    }

    @Test
    void allowEntryOfAnAppointment() {
        calendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2020 02:00 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment enteredAppt = appointments.get(0);

        assertAll(
            () -> assertEquals("Jim", enteredAppt.getPatientFirstName()),
            () -> assertEquals("Weaver", enteredAppt.getPatientLastName()),
            () -> assertSame(Doctor.avery, enteredAppt.getDoctor()),
            () -> assertEquals("9/1/2020 02:00 PM",
                    enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")))
        );
    }

    @Nested
    @DisplayName("indicate if there are appointments correctly")
    class HasAppointments {

        @Test
        @DisplayName("when there are appointments")
        void returnTrueForHasAppointmentsIfThereAreAppointments() {
            calendar.addAppointment("Jim", "Weaver", "avery",
                    "09/01/2020 02:00 pm");
            assertTrue(calendar.hasAppointment(LocalDate.of(2020, 9, 1)));
        }

        @Test
        @DisplayName("when there are no appointments")
        void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
            assertFalse(calendar.hasAppointment(LocalDate.of(2020, 9, 1)));
        }
    }

    @Nested
    @DisplayName("return appointments correctly")
    class AppointmentsForDay {

        @Test
        @DisplayName("for today")
        void returnCurrentDaysAppointment() {
            calendar.addAppointment("Hardik", "Joshi", "avery",
                    "09/01/2020 11:00 AM");
            calendar.addAppointment("Bhavesh", "Patel", "avery",
                    "09/01/2020 11:30 AM");
            calendar.addAppointment("Juhi", "Joshi", "avery",
                    "09/10/2020 12:00 PM");
            assertEquals(2, calendar.getTodayAppointments().size());
        }

        @Test
        @DisplayName("for tomorrow")
        void returnTomorrowsAppointment() {
            calendar.addAppointment("Hardik", "Joshi", "avery",
                    "09/02/2020 11:00 AM");
            calendar.addAppointment("Bhavesh", "Patel", "avery",
                    "09/02/2020 11:30 AM");
            calendar.addAppointment("Juhi", "Joshi", "avery",
                    "09/01/2020 12:00 PM");
            assertEquals(2, calendar.getTomorrowAppointments().size());
        }
    }

    @Nested
    @DisplayName("return upcoming appointments")
    class UpcomingAppointments {

        @Test
        @DisplayName("an empty list when there are none")
        void whenThereAreNone() {
            List<PatientAppointment> appointments = calendar.getUpcomingAppointments();
            assertEquals(0, appointments.size());
        }

        @Test
        @DisplayName("correctly when there are some in the past as well")
        void whenThereAreSomePastAndFuture() {
            calendar.addAppointment("Hardik", "Joshi", "avery",
                    "08/02/2020 11:00 AM");
            calendar.addAppointment("Bhavesh", "Patel", "avery",
                    "08/02/2020 11:30 AM");
            calendar.addAppointment("Juhi", "Joshi", "avery",
                    "09/02/2020 12:00 PM");
            assertEquals(1, calendar.getUpcomingAppointments().size());
        }
    }
}
package test;
//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Appointment;

class AppointmentTest {

	@Test
	@DisplayName("Test creating an appointment successffuly")
	void testCreateAppointmentSuccess() {
		
		Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		
		assertTrue(appointment != null, "Create Appointment Fail");
		assertTrue(appointment.getAppointmentId().equals("1234567890"), "Create Appointment Fail: Id");
		assertTrue(appointment.getAppointmentDate().equals("2022-12-01"), "Create Appointment Fail: Date");
		assertTrue(appointment.getAppointmentDescription().equals("Dr. appointment at Sentara at 10am."), "Create Appointment Fail: Description");
	}
	
	@Test
	@DisplayName("Test creating an appointment with Id too long")
	void testCreateAppointmentIdTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678900", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		}, "Create Appointment Fail: Id Too Long");	
	}
	
	@Test
	@DisplayName("Test creating an appointment with null Id")
	void testCreateAppointmentNullId() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Appointment(null, "2022-12-01", "Dr. appointment at Sentara at 10am.");
		}, "Create Appointment Fail: Id Null");	
	}
	
	@Test
	@DisplayName("Test creating an appointment with date that is in the past")
	void testCreateAppointmentDatePast() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Appointment("12345678900", "2022-01-01", "Dr. appointment at Sentara at 10am.");
		}, "Create Appointment Fail: Past Date");	
	}
	
	@Test 
	@DisplayName("Test creating an appointment with incorrect date format")
	public void testCreateAppointmentInvalidDateFormat() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("1234567890", "2022912901", "Dr. appointment at Sentara at 10am.");	
		}, "Create Appointment Fail: Incorrect Date Format");
	}	
	
	@Test
	@DisplayName("Test creating an appointment with null date")
	void testCreateAppointmentNullDate() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Appointment("12345678900", null, "Dr. appointment at Sentara at 10am.");
		}, "Create Appointment Fail: Date Null");	
	}
	
	@Test
	@DisplayName("Test creating an appointment with description that is too long")
	void testCreateAppointmentDescriptionTooLong() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am. Arrive 15 minutes early so that you can check-in.");
		}, "Create Appointment Fail: Description Too Long");	
	}
	
	@Test
	@DisplayName("Test creating an appointment with null description")
	void testCreateAppointmentNullDescription() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Appointment("1234567890", "2022-12-01", null);
		}, "Create Appointment Fail: Description Null");	
	}
	
	@Test
	@DisplayName("Test updating an appointment successffuly")
	void testUpdateAppointmentSuccess() {
		
		Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");	

		appointment.setAppointmentDate("2022-11-01");
		appointment.setAppointmentDescription("New Description");

		assertTrue(appointment.getAppointmentId().equals("1234567890"), "ID not set.");
		assertTrue(appointment.getAppointmentDate().equals("2022-11-01"), "Update Appointment Fail: Date");
		assertTrue(appointment.getAppointmentDescription().equals("New Description"), "Update Appointment Fail: Description");
	}
	
	@Test
	@DisplayName("Test updating an appointment with date that is in the past")
	void testUpdateAppointmentDatePast() {
		
		Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");	
		
		assertFalse(appointment.setAppointmentDate("2022-01-01"), "Update Date Fail: Past");
	}
	
	@Test
	@DisplayName("Test updating appointment with null date")
	void testUpdateAppointmentNullDate() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");
			appointment.setAppointmentDate(null);
		}, "Update Date Fail: Null");
	}
	
	@Test 
	@DisplayName("Test updating an appointment with incorrect date format")
	public void testUpdateAppointmentInvalidDateFormat() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");
			appointment.setAppointmentDate("2022912901");
		}, "Update Date Fail: Format");
	}	
		
	@Test
	@DisplayName("Test updating an appointment with description that is too long")
	void testUpdateAppointmentDescriptionTooLong() {
		
		Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");	
		
		assertFalse(appointment.setAppointmentDescription("New Description New Description New Description New Description"), "Update Description: Too Long");
	}

	@Test
	@DisplayName("Test updating an appointment with null description")
	void testUpdateAppointmentNullDescription() {
		
		Appointment appointment = new Appointment("1234567890", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		
		assertFalse(appointment.setAppointmentDescription(null), "Update Description: Null");
	}
}

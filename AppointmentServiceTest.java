package test;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Appointment;
import services.AppointmentService;

class AppointmentServiceTest 
{

	private static AppointmentService appointmentService;
	
	@BeforeAll
	static void setup(){
		appointmentService = AppointmentService.getService();
	}
	
	@Test
	@DisplayName("Test adding appointment successffuly")
	void testAddAppointmentSuccess() {
		
		Appointment appointment = new Appointment("0000000001", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		
		assertTrue(appointmentService.addAppointment(appointment), "Add Appointment Fail");
		assertTrue("0000000001".contentEquals(appointment.getAppointmentId()), "Add Appointment Fail: Id");
		assertTrue("2022-12-01".contentEquals(appointment.getAppointmentDate()), "Add Appointment Fail: Date");
		assertTrue("Dr. appointment at Sentara at 10am.".contentEquals(appointment.getAppointmentDescription()), "Add Appointment Fail: Description");
	}
	
	@Test
	@DisplayName("Test adding multiple appointment successffuly")
	void testAddMultipleAppointmentSuccess() {
		
		Appointment appointment1 = new Appointment("0000000002", "2022-12-01", "");
		Appointment appointment2 = new Appointment("0000000003", "2022-12-01", "1");
		Appointment appointment3 = new Appointment("0000000004", "2022-12-01", "Test49CharactersTest49CharactersTest49Characters!");
		Appointment appointment4 = new Appointment("0000000005", "2022-12-25", "!TestMax50CharacterLimit!!TestMax50CharacterLimit!");
		
		assertTrue(appointmentService.addAppointment(appointment1), "Add Multiple Appointments Fail: String Length = 0");	
		assertTrue(appointmentService.addAppointment(appointment2), "Add Multiple Appointments Fail: String Length = 1");
		assertTrue(appointmentService.addAppointment(appointment3), "Add Multiple Appointments Fail: String Length = 49");
		assertTrue(appointmentService.addAppointment(appointment4), "Add Multiple Appointments Fail: String Length = 50");
	}
	
	@Test
	@DisplayName("Test adding duplicate appointment Ids")
	void testAddDuplicateIdFail() {
		
		Appointment appointment1 = new Appointment("0000000006", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		Appointment appointment2 = new Appointment("0000000006", "2022-12-25", "Christmas dinner with the FamBam.");
		
		assertTrue(appointmentService.addAppointment(appointment1), "Add Duplicate Appointment IDs Fail: appointment1");		
		assertFalse(appointmentService.addAppointment(appointment2), "Add Duplicate Appointment IDs Fail: appointment2");
	}
		
	@Test
	@DisplayName("Test deleting an appointment successfully")
	void testGetAppointmentAndDeleteSuccess() {
		
		Appointment appointment = new Appointment("0000000007", "2022-12-01", "Dr. appointment at Sentara at 10am.");
		
		assertTrue(appointmentService.addAppointment(appointment), "Delete Appointment Fail: Add Appointment");	
		assertTrue(appointmentService.deleteAppointment(appointment.getAppointmentId()), "Delete Appointment Fail: Delete Appointment");
		assertTrue(appointmentService.getAppointment(appointment.getAppointmentId()) == null, "Delete Appointment Fail: Get Appointment");
	}

	@Test 
	@DisplayName("Test deleting an appointment with nonexistant Id")
	void testDeleteInvalidAppointmentFail() {
		
		String invalidAppointmentId = "0000000008";
		
		assertFalse(appointmentService.deleteAppointment(invalidAppointmentId), "Delete Nonexistant Appointment ID Fail");
	}
}

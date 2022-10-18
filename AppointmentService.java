package services;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import java.util.HashMap;
import java.util.Map;
import model.Appointment;

public class AppointmentService 
{
	// Local variables
	private static AppointmentService reference = new AppointmentService();
	private final Map<String, Appointment> appointments;
	
	// HashMap to store key value pair with unique ID and appointments 
	public AppointmentService()
	{
		this.appointments = new HashMap<String, Appointment>();
	}
	
	// Method to create instance of Singleton AppointmentService
	public static AppointmentService getService()
	{
		return reference;
	}
	
	// Method to add an appointments with a unique Id
	public boolean addAppointment(Appointment appointment)
	{
		boolean isSuccess = false;
		
		if(!appointments.containsKey(appointment.getAppointmentId()))
		{
			appointments.put(appointment.getAppointmentId(), appointment);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	// Method to delete an appointments per appointment Id
	public boolean deleteAppointment(String appointmentId)
	{		
		return appointments.remove(appointmentId) != null;
	}
	
	// Method to retrieve Appointment object
	public Appointment getAppointment(String appointmentId)
	{
		return appointments.get(appointmentId);
	}
	
}

package model;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Appointment 
{
	// Local variables
	private String appointmentId;
	private String appointmentDate; 
	private String appointmentDescription;
	
	// Constructor
	public Appointment(String appointmentId, String appointmentDate, String appointmentDescription)
	{
		boolean isValid = validateInput(appointmentId, 10);
		
		
		if(isValid)
		{
			this.appointmentId = appointmentId;
		}
		
		isValid = isValid && setAppointmentDate(appointmentDate);
		isValid = isValid && setAppointmentDescription(appointmentDescription);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}
	
	// Mutators
	public boolean setAppointmentDate(String appointmentDate)
	{
		boolean isValid = false;
		
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Null date input");
		}
		
		else {
			Date today = new Date();
			Date CheckDate = parseDate(appointmentDate);
			
			isValid = today.before(CheckDate);
			
			if(isValid)
			{
				this.appointmentDate = appointmentDate;
			}
		}
	
		return isValid;
	}
	
	public boolean setAppointmentDescription(String appointmentDescription) 
	{
		boolean isValid = validateInput(appointmentDescription, 50);
		
		if(isValid)
		{
			this.appointmentDescription = appointmentDescription;
		}
		
		return isValid;
	}
	
	// Accessors
	public String getAppointmentId ()
	{
		return appointmentId;
	}
	
	public String getAppointmentDate ()
	{
		return appointmentDate;
	}
	
	public String getAppointmentDescription ()
	{
		return appointmentDescription;
	}
	
	// Method to validate input is not null and meets length requirements
	private boolean validateInput(String item, int length)
	{
		return(item != null && item.length() <= length);
	}
	
	// Method to format date string to date object
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	    	 throw new IllegalArgumentException("Incorrect date format"); 
	     }
	  }
}

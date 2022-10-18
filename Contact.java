package model;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

//Reference for Regex: https://codingnconcepts.com/java/java-regex-to-validate-phone-number/

public class Contact 
{
	// Local variables
	private String contactId;
	private String contactFirstName;
	private String contactLastName;
	private String contactNumber;
	private String contactAddress;
	public boolean digits = true; 
	
	// Constructor	
	public Contact (String contactId, String contactFirstName, String contactLastName, String contactNumber, String contactAddress) 
	{
		boolean isValid = validateInput(contactId, 10);
		
		
		if(isValid)
		{
			this.contactId = contactId;
		}
		
		isValid = isValid && setContactFirstName(contactFirstName);
		isValid = isValid && setContactLastName(contactLastName);
		isValid = isValid && setContactNumber(contactNumber);
		isValid = isValid && setContactAddress(contactAddress);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}

	// Mutators
	public boolean setContactFirstName(String contactFirstName) 
	{
		boolean isValid = validateInput(contactFirstName, 10);
		
		if(isValid)
		{
			this.contactFirstName = contactFirstName;
		}
		
		return isValid;
	}
	
	public boolean setContactLastName(String contactLastName) 
	{
		boolean isValid = validateInput(contactLastName, 10);
		
		if(isValid)
		{
			this.contactLastName = contactLastName;
		}
		
		return isValid;
	}
	
	public boolean setContactAddress(String contactAddress) 
	{
		boolean isValid = validateInput(contactAddress, 30);
		
		if(isValid)
		{
			this.contactAddress = contactAddress;
		}
		
		return isValid;
	}
	
	public boolean setContactNumber(String contactNumber) 
	{
		boolean isValid = false;
		if(!validateInput(contactNumber, 10))
		{
			isValid = false;
		}
		else if (contactNumber.length() == 10 && contactNumber.matches("^\\d{10}$"))
		{
			this.contactNumber = contactNumber;
			isValid = true;
		}
		
		return isValid;
	}
	
	// Accessors
	public String getContactId()  
	{
		return contactId;
	}
	
	public String getContactFirstName() 
	{
		return contactFirstName;
	}
	
	public String getContactLastName()
	{
		return contactLastName;
	}
	
	public String getContactNumber() 
	{
		return contactNumber;
	}
	
	public String getContactAddress() 
	{
		return contactAddress;
	}
	
	// Method to validate input is not null and meets length requirements
	private boolean validateInput(String item, int length)
	{
		return(item != null && item.length() <= length);
	}
	
}

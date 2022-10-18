package services;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

import java.util.HashMap;
import java.util.Map;

import model.Contact;

public class ContactService {
	
	// Local variables
	private static ContactService reference = new ContactService();
	private final Map<String, Contact> contacts;
		
	// HashMap to store key value pair with unique ID and contacts 
	public ContactService()
	{
		this.contacts = new HashMap<String, Contact>();
	}
	
	// Method to create instance of Singleton ContactService
	public static ContactService getService()
	{
		return reference;
	}
		
	// Method to add a contact with a unique Id
	public boolean addContact(Contact contact)
	{
		boolean isSuccess = false;
			
		if(!contacts.containsKey(contact.getContactId()))
		{
			contacts.put(contact.getContactId(), contact);
			isSuccess = true;
		}
			
		return isSuccess;
	}
		
	// Method to delete a contact per contact Id
	public boolean deleteContact(String contactId)
	{		
		return contacts.remove(contactId) != null;
	}
		
	// Method to update a contact first name per contact Id
	public boolean updateContactFirstName(String contactId, String updatedContactFirstName)
	{		
		boolean isSuccess = false;
		
		if(contacts.containsKey(contactId))
		{
			getContact(contactId).setContactFirstName(updatedContactFirstName);
			if(getContact(contactId).getContactFirstName() ==  updatedContactFirstName)
			{
				isSuccess = true;
			}		
		}
	
		return isSuccess;
	}
	
	// Method to update a contact last name per contact Id
	public boolean updateContactLastName(String contactId, String updatedContactLastName)
	{		
		boolean isSuccess = false;
		if(contacts.containsKey(contactId))
		{
			getContact(contactId).setContactLastName(updatedContactLastName);
			if(getContact(contactId).getContactLastName() ==  updatedContactLastName)
			{
				isSuccess = true;
			}
		}
			
		return isSuccess;
	}
	
	// Method to update a contact phone number per contact Id
	public boolean updateContactNumber(String contactId, String updatedContactNumber)
	{		
		boolean isSuccess = false;
		if(contacts.containsKey(contactId))
		{
			getContact(contactId).setContactNumber(updatedContactNumber);
			if(getContact(contactId).getContactNumber() ==  updatedContactNumber)
			{
				isSuccess = true;
			}
		}
				
		return isSuccess;
	}

	// Method to update a contact address per contact Id
	public boolean updateContactAddress(String contactId, String updatedContactAddress)
	{		
		boolean isSuccess = false;
		if(contacts.containsKey(contactId))
		{
			getContact(contactId).setContactAddress(updatedContactAddress);
			if(getContact(contactId).getContactAddress() ==  updatedContactAddress)
			{
				isSuccess = true;
			}
		}
				
		return isSuccess;
	}
			
	// Method to retrieve Contact object
	public Contact getContact(String contactId)
	{
		return contacts.get(contactId);
	} 
}
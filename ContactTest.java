package test;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

// Reference for assertAll: https://www.javaguides.net/2018/09/junit-5-assertall-example.html
// Reference for JUnit Test Framework: https://www.tutorialspoint.com/junit/junit_test_framework.htm
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactTest  
{

	@Test
	@DisplayName("Test creating contact successffuly")
	void testCreateContactSuccess() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertTrue(contact != null, "Create Contact Fail");
		assertTrue(contact.getContactId().equals("0000000001"), "Create Contact Fail: Id");
		assertTrue(contact.getContactFirstName().equals("Jane"), "Create Contact Fail: First Name");
		assertTrue(contact.getContactLastName().equals("Doe"), "Create Contact Fail: Last Name");
		assertTrue(contact.getContactNumber().equals("7578675309"), "Create Contact Fail: Number");
		assertTrue(contact.getContactAddress().equals("100 Plain Wy. Boston MA 11111"), "Create Contact Fail: Address");
	}
	
	@Test
	@DisplayName("Test creating contact with Id too long")
	void testCreateContactIdTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("00000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Id Too Long");	
	}
	
	@Test
	@DisplayName("Test creating contact with null Id")
	void testCreateContactNullId() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Id Null");	
	}
	
	@Test
	@DisplayName("Test creating contact with first name that is too long")
	void testCreateContactFirstNameTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "TooLongName", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: First Name Too Long");	
	}
	
	@Test
	@DisplayName("Test creating contact with null first name")
	void testCreateContactNullName() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", null, "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: First Name Null");	
	}
	
	@Test
	@DisplayName("Test creating contact with last name that is too long")
	void testCreateContactLastNameTooLong() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "TooLongName", "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Last Name Too Long");	
	}
	
	@Test
	@DisplayName("Test creating contact with null last name")
	void testCreateContactNullLastName() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", null, "7578675309", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Last Name null");	
	}
	
	@Test
	@DisplayName("Test creating contact with phone number that is too long")
	void testCreateContactNumberTooLong() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", "75786753091", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Phone Number too long");	
	}
	
	@Test
	@DisplayName("Test creating contact with phone number that is too short")
	void testCreateContactNumberTooShort() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", "757867530", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Phone Number too short");	
	}
	
	@Test
	@DisplayName("Test creating contact with phone number that does not have only digits")
	void testCreateContactNonDigitNumber() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", "75786753o9", "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Phone Number has non-digits");	
	}
	
	@Test
	@DisplayName("Test creating contact with null phone number")
	void testCreateContactNullNumber() {	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", null, "100 Plain Wy. Boston MA 11111");
		}, "Create Contact Fail: Phone Number null");	
	}
	
	@Test
	@DisplayName("Test creating contact with address that is too long")
	void testCreateContactAddressTooLong() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", "7578675309", "This Address Is Too Long. Cannot exceed 30 characters.");
		}, "Create Contact Fail: Address too long");	
	}
	
	@Test
	@DisplayName("Test creating contact with null address")
	void testCreateContacNullAddress() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Jane", "Doe", "7578675309", null);
		}, "Create Contact Fail: Address Null");	
	}
		
	@Test
	@DisplayName("Test updating contact successffuly")
	void testUpdateTaskSuccess() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	

		contact.setContactFirstName("New First");
		contact.setContactLastName("New Last");
		contact.setContactNumber("9894215876");
		contact.setContactAddress("New Address");
		
		assertTrue(contact.getContactId().equals("0000000001"), "ID not set.");
		assertTrue(contact.getContactFirstName().equals("New First"), "Update Contact Fail: First Name");
		assertTrue(contact.getContactLastName().equals("New Last"), "Update Contact Fail: Last Name");
		assertTrue(contact.getContactNumber().equals("9894215876"), "Update Contact Fail: Phone Number");
		assertTrue(contact.getContactAddress().equals("New Address"), "Update Contact Fail: Address");
	}	

	@Test
	@DisplayName("Test updating contact with first name that is too long")
	void testUpdateContactFirstNameTooLong() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertFalse(contact.setContactFirstName("TooLongName"), "Update First Name Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating contact with null first name")
	void testUpdateContactNullFirstName() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactFirstName(null), "Update First Name Fail: Null");
	}
	
	@Test
	@DisplayName("Test updating contact with last name that is too long")
	void testUpdateContactLastNameTooLong() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertFalse(contact.setContactLastName("TooLongName"), "Update Last Name Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating contact with null last name")
	void testUpdateContactNullLastName() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactLastName(null), "Update Last Name Fail: Null");
	}
	
	@Test
	@DisplayName("Test updating contact with phone number that is too long")
	void testUpdateContactNumberTooLong() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactNumber("75786753091"), "Update Phone Number Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating contact with phone number that is too short")
	void testUpdateContactNumberTooShort() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertFalse(contact.setContactNumber("757867530"), "Update Phone Number Fail: Too Short");
	}
	
	@Test
	@DisplayName("Test updating contact with phone number that does not onlyy contain digits")
	void testUpdateContactNumberNonDigit() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactNumber("75786753o9"), "Update Phone Number Fail: Contains Non-digits");
	}
	
	@Test
	@DisplayName("Test updating contact with null phone number")
	void testUpdateContactNullNumber() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertFalse(contact.setContactNumber(null), "Update Phone Number Fail: Null");
	}
	
	@Test
	@DisplayName("Test updating contact with address that is too long")
	void testUpdateContactAddressTooLong() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactAddress("This Address Is Too Long. Cannot exceed 30 characters."), "Update Address Fail: Too Long");
	}
	
	@Test
	@DisplayName("Test updating contact with null address")
	void testUpdateContactNullAddress() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");	
		
		assertFalse(contact.setContactAddress(null), "Update Address Fail: Null");
	}
}

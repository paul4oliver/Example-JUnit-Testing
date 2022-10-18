package test;

//PAUL KENAGA
//CS 320 PROJECT ONE
//10/08/2022

// Reference for JUnit Test Case: https://www.javatpoint.com/junit-test-case-example-in-java	
// Reference for assertAll: https://www.javaguides.net/2018/09/junit-5-assertall-example.html

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Contact;

import org.junit.jupiter.api.DisplayName;

import services.ContactService;

class ContactServiceTest {
	
	private static ContactService contactService;

	@BeforeAll
	static void setup() {
		
		contactService = ContactService.getService();	
	}

	@Test
	@DisplayName("Test adding contact successffuly")
	void testAddContactSuccess() {
		
		Contact contact = new Contact("0000000001", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		
		assertTrue(contactService.addContact(contact), "Add Contact Fail");
		assertTrue("0000000001".contentEquals(contact.getContactId()), "Add Contact Fail: Id");
		assertTrue("Jane".contentEquals(contact.getContactFirstName()), "Add Contact Fail: First Name");
		assertTrue("Doe".contentEquals(contact.getContactLastName()), "Add Contact Fail: Last Name");
		assertTrue("7578675309".contentEquals(contact.getContactNumber()), "Add Contact Fail: Phone Number");
		assertTrue("100 Plain Wy. Boston MA 11111".contentEquals(contact.getContactAddress()),"Add Contact Fail: Address");
	}

	@Test
	@DisplayName("Test adding multiple contacts successffuly")
	void testAddMultipleContactsSuccess() {
		
		Contact contact1 = new Contact("0000000002", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		Contact contact2 = new Contact("0000000003", "John", "Smith", "2853694587", "102 Blank Rd. Newton GA 11112");

		assertTrue(contactService.addContact(contact1), "Add Multiple Contacts Fail: contact1");
		assertTrue(contactService.addContact(contact2), "Add Multiple Contacts Fail: contact2");
	}

	@Test
	@DisplayName("Test adding duplicate contact Ids")
	void testAddDuplicateIdFail() {
		
		Contact contact3 = new Contact("0000000004", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");
		Contact contact4 = new Contact("0000000004", "John", "Smith", "2853694587", "102 Blank Rd. Newton GA 11112");

		assertTrue(contactService.addContact(contact3), "Add Duplicate Contact IDs Fail: contact1");
		assertFalse(contactService.addContact(contact4), "Add Duplicate Contact IDs Fail: contact2");
	}

	@Test
	@DisplayName("Test deleting a contact successfully")
	void testGetContactAndDeleteSuccess() {
		
		Contact contact5 = new Contact("0000000005", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact5), "Delete Contact Fail: Add Contact");
		assertTrue(contactService.deleteContact(contact5.getContactId()), "Delete Contact Fail: Delete Contact");
		assertTrue(contactService.getContact(contact5.getContactId()) == null, "Delete Contact Fail: Get Contact");
	}

	@Test
	@DisplayName("Test deleting a contact with nonexistant Id")
	void testDeleteInvalidContactFail() {
		
		String invalidContactId = "1";

		assertFalse(contactService.deleteContact(invalidContactId), "Delete Nonexistant Contact ID Fail");
	}

	@Test
	@DisplayName("Test updating a contact first name successfully")
	void testUpdateFirstNameSuccess() {
		
		Contact contact6 = new Contact("0000000006", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact6);
		contactService.updateContactFirstName(contact6.getContactId(), "Updated FN");

		assertTrue(contact6.getContactFirstName().equals("Updated FN"), "Update First Name Fail: 0 < String Length < 10");
	}
	@Test
	
	@DisplayName("Test updating a contact first name to empty string successfully")
	void testUpdateEmptyFirstNameSuccess() {
		
		Contact contact7 = new Contact("0000000020", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact7);
		contactService.updateContactFirstName(contact7.getContactId(), "Updated FN");

		assertTrue(contact7.getContactFirstName().equals("Updated FN"), "Update First Name Fail: String Length = 0");
	}
	
	@Test
	@DisplayName("Test getting and updating a contact first name that is too long")
	void testGetContactAndUpdateFirstNameTooLong() {
		
		Contact contact8 = new Contact("0000000007", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact8), "Failed to add contact");
		assertFalse(contactService.updateContactFirstName(contact8.getContactId(), "Update FN Too Long"), "Update First Name Fail: String Length > 10");

	} 

	@Test
	@DisplayName("Test getting and updating a contact first name with null")
	void testGetTaskAndUpdateFirstNameNull() {
		
		Contact contact9 = new Contact("0000000008", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact9), "Failed to add contact");
		assertFalse(contactService.updateContactFirstName(contact9.getContactId(), null), "Update First Name Fail: Null");
	}

	@Test
	@DisplayName("Test getting and updating a contact last name successfully")
	void testGetContactAndUpdateLastNameSuccess() {
		
		Contact contact10 = new Contact("0000000009", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact10);
		contactService.updateContactLastName(contact10.getContactId(), "Updated LN");
		
		assertTrue(contact10.getContactLastName().equals("Updated LN"), "Update Last Name Fail: 0 < String Length < 10");
	}
	
	@Test
	@DisplayName("Test getting and updating a contact last name to an empty string successfully")
	void testGetContactAndUpdateEmptyLastNameSuccess() {
		
		Contact contact11 = new Contact("0000000021", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact11);
		contactService.updateContactLastName(contact11.getContactId(), "");
		
		assertTrue(contact11.getContactLastName().equals(""), "Update Last Name Fail: String Length = 0");
	}

	@Test
	@DisplayName("Test getting and updating a contact last name that is too long")
	void testGetContactAndUpdateLastNameTooLong() {
		
		Contact contact12 = new Contact("0000000010", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact12), "Failed to add contact");
		assertFalse(contactService.updateContactLastName(contact12.getContactId(), "Update LN Too Long"), "Update Last Name Fail: String Length > 10");
	}

	@Test
	@DisplayName("Test getting and updating a contact last name with null")
	void testGetTaskAndUpdateLastNameNull() {
		
		Contact contact13 = new Contact("0000000011", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact13), "Failed to add contact");
		assertFalse(contactService.updateContactLastName(contact13.getContactId(), null), "Update Last Name Fail: Null");
	}

	@Test
	@DisplayName("Test getting and updating a contact address successfully")
	void testGetContactAndUpdateAddressSuccess() {
		
		Contact contact14 = new Contact("000000020", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact14);
		contactService.updateContactAddress(contact14.getContactId(), "Updated Address");

		assertTrue(contact14.getContactAddress().equals("Updated Address"), "Update Address Fail: 0 < String Length < 50");
	}
	
	@Test
	@DisplayName("Test getting and updating a contact addressto an empty string successfully")
	void testGetContactAndUpdateEmptyAddressSuccess() {
		
		Contact contact15 = new Contact("0000000012", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact15);
		contactService.updateContactAddress(contact15.getContactId(), "");

		assertTrue(contact15.getContactAddress().equals(""), "Update Address Fail: String Length = 0");
	}

	@Test
	@DisplayName("Test getting and updating a contact address that is too long")
	void testGetContactAndUpdateAddressTooLong() {
		
		Contact contact16 = new Contact("0000000013", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact16), "Failed to add contact");
		assertFalse(contactService.updateContactAddress(contact16.getContactId(),"Update Address That Is Too Long. Cannot Exceed 30 Characters."), "Update Address Fail: String Length > 30");
	}

	@Test
	@DisplayName("Test getting and updating a contact address with null")
	void testGetTaskAndUpdateAddressNull() {
		
		Contact contact17 = new Contact("0000000014", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact17), "Failed to add contact");
		assertFalse(contactService.updateContactAddress(contact17.getContactId(), null), "Update Address Fail: Null");
	}

	@Test
	@DisplayName("Test getting and updating a contact phone number successfully")
	void testGetContactAndUpdateNumberNameSuccess() {
		
		Contact contact18 = new Contact("0000000015", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		contactService.addContact(contact18);
		contactService.updateContactNumber(contact18.getContactId(), "4663751243");

		assertTrue(contact18.getContactNumber().equals("4663751243"), "Update Number Fail:  String Length = 10");
	}

	@Test
	@DisplayName("Test getting and updating a contact phone number that is too long")
	void testGetContactAndUpdateNumberTooLong() {
		
		Contact contact19 = new Contact("0000000016", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact19), "Failed to add contact");
		assertFalse(contactService.updateContactNumber(contact19.getContactId(), "75789465123"), "Update Address Fail: String Length > 10");
	}

	@Test
	@DisplayName("Test getting and updating a contact phone number that is too short")
	void testGetTaskAndUpdateNumberTooShort() {
		
		Contact contact20 = new Contact("0000000017", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact20), "Failed to add contact");
		assertFalse(contactService.updateContactNumber(contact20.getContactId(), "757867530"), "Update Address Fail: String Length < 10");
	}

	@Test
	@DisplayName("Test getting and updating a contact phone number that does not contain only digits")
	void testGetTaskAndUpdateNumberNonDigit() {
		
		Contact contact21 = new Contact("0000000018", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact21), "Failed to add contact");
		assertFalse(contactService.updateContactNumber(contact21.getContactId(), "757867530A"), "Update Phone Number Fail: Contains Non-digit Character(s)");
	}
 
	@Test
	@DisplayName("Test getting and updating a contact phone number with null")
	void testGetTaskAndUpdateNumberNull() {
		
		Contact contact22 = new Contact("0000000019", "Jane", "Doe", "7578675309", "100 Plain Wy. Boston MA 11111");

		assertTrue(contactService.addContact(contact22), "Failed to add contact");
		assertFalse(contactService.updateContactNumber(contact22.getContactId(), null), "Update Phone Number Fail: Null");
	}
}

package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

    @Test
    @DisplayName("Creates an AddressBook instance")
    void testAddressBookCreation() {
        // Arrange

        // Act
        AddressBook addressBook = new AddressBook();

        // Assert
        assertNotNull(addressBook, "AddressBook instance should not be null");
    }
    @Test
    @DisplayName("Adds a new contact to the AddressBook")
    void testAddContact() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = mock(Contacts.class);

        when(mockContact.getName()).thenReturn("Mock Name");
        when(mockContact.getEmail()).thenReturn("mockemail@gmail.com");
        when(mockContact.getPhoneNumber()).thenReturn("1234567890");

        // Act
        assertDoesNotThrow(() -> addressBook.addContact(mockContact));

        // Assert
        assertTrue(addressBook.getContacts().contains(mockContact));
    }

    @Test
    @DisplayName("Prints confirmation of contact added to AddressBook")
    void testPrintContactDetails() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = mock(Contacts.class);

        when(mockContact.getName()).thenReturn("Adam Appleton");
        when(mockContact.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact.getPhoneNumber()).thenReturn("1234567890");

        // Act
        assertDoesNotThrow(() -> addressBook.addContact(mockContact));

        // Assert
        ArrayList<Contacts> contacts = addressBook.getContacts();
        System.out.printf("%n========================================================================%n");
        System.out.printf("Name: %-20sEmail: %-20sPhone: %-20s%n", contacts.get(0).getName(), contacts.get(0).getEmail(), contacts.get(0).getPhoneNumber());
        System.out.printf("========================================================================%n");
        assertEquals("Adam Appleton", contacts.get(0).getName());
        assertEquals("adama@gmail.com", contacts.get(0).getEmail());
        assertEquals("1234567890", contacts.get(0).getPhoneNumber());
    }

 // User Story 5: As an end user, I want an exception to throw if I haven't populated all 3 attributes (name, phone, email), so that my contact is complete
     @Test
     @DisplayName("Throws an exception when name null")
     void testExceptionWithNullName() {
         // Arrange
         AddressBook addressBook = new AddressBook();
         Contacts mockContact = mock(Contacts.class);

         // Act
         when(mockContact.getName()).thenReturn(null);
         when(mockContact.getEmail()).thenReturn("bettyb@gmail.com");
         when(mockContact.getPhoneNumber()).thenReturn("1212121212");

         // Assert
         Exception e = assertThrows(IncompleteContactException.class, () -> {
             addressBook.addContact(mockContact);
         });

         assertEquals("All contact details must be provided (name, email, phone number)", e.getMessage());
     }

    @Test
    @DisplayName("Throws an exception when email null")
    void testExceptionWithNullEmail() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = mock(Contacts.class);

        // Act
        when(mockContact.getName()).thenReturn("Betty Boop");
        when(mockContact.getEmail()).thenReturn(null);
        when(mockContact.getPhoneNumber()).thenReturn("1212121212");

        // Assert
        Exception e = assertThrows(IncompleteContactException.class, () -> {
            addressBook.addContact(mockContact);
        });

        assertEquals("All contact details must be provided (name, email, phone number)", e.getMessage());
    }

    @Test
    @DisplayName("Throws an exception when phone number null")
    void testExceptionWithNullPhoneNumber() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = mock(Contacts.class);

        // Act
        when(mockContact.getName()).thenReturn("Betty Boop");
        when(mockContact.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact.getPhoneNumber()).thenReturn(null);

        // Assert
        Exception e = assertThrows(IncompleteContactException.class, () -> {
            addressBook.addContact(mockContact);
        });

        assertEquals("All contact details must be provided (name, email, phone number)", e.getMessage());
    }

    // User Story 6: As an end user, I want an option to view all contacts in the address book, so that I can get an overview.
    @Test
    @DisplayName("View all contacts in the AddressBook")
    void testViewAllContacts() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        // Act

        // Assert
        assertDoesNotThrow(() -> {
            addressBook.addContact(mockContact1);
            addressBook.addContact(mockContact2);
            addressBook.addContact(mockContact3);
        });

        ArrayList<Contacts> contacts = addressBook.getContacts();
        System.out.printf("%n========================================================================%n");
        System.out.printf("Name: %-20s Email: %-20s Phone: %-20s%n", contacts.get(0).getName(), contacts.get(0).getEmail(), contacts.get(0).getPhoneNumber());
        System.out.printf("Name: %-20s Email: %-20s Phone: %-20s%n", contacts.get(1).getName(), contacts.get(1).getEmail(), contacts.get(1).getPhoneNumber());
        System.out.printf("Name: %-20s Email: %-20s Phone: %-20s%n", contacts.get(2).getName(), contacts.get(2).getEmail(), contacts.get(2).getPhoneNumber());
        System.out.printf("========================================================================%n");
    }

    @Test
    @DisplayName("Assert the retrieved list of contacts is equal to the list originally added")
    void testContactsArrayEqualToInput() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        // Act
        assertDoesNotThrow(() -> {
            addressBook.addContact(mockContact1);
            addressBook.addContact(mockContact2);
            addressBook.addContact(mockContact3);
        });

        // Assert
        ArrayList<Contacts> contacts = addressBook.getContacts();
        assertTrue(contacts.contains(mockContact1));
        assertTrue(contacts.contains(mockContact2));
        assertTrue(contacts.contains(mockContact3));
    }

    // User Stories 7-9: As an end user, I want to search through my contacts by name, email, phone so that I can view their details.
    @Test
    @DisplayName("Search contact by name")
    void testSearchContactByName() throws ContactNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        assertDoesNotThrow(() -> {
            addressBook.addContact(mockContact1);
            addressBook.addContact(mockContact2);
            addressBook.addContact(mockContact3);
        });

        // Act - Input what name to search
        Contacts result = addressBook.searchContactByName("Betty Boop");

        // Assert
        assertEquals("Betty Boop", result.getName(), "Returned contact name should equal search name");
    }

    @Test
    @DisplayName("Search contact by email")
    void testSearchContactByEmail() throws ContactNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        assertDoesNotThrow(() -> {
            addressBook.addContact(mockContact1);
            addressBook.addContact(mockContact2);
            addressBook.addContact(mockContact3);
        });

        // Act - Input what email to search
        Contacts result = addressBook.searchContactByEmail("ciarac@gmail.com");

        // Assert
        assertEquals("ciarac@gmail.com", result.getEmail(), "Returned contact email should equal search email");
    }

    @Test
    @DisplayName("Search contact by phone number")
    void testSearchContactByPhoneNumber() throws ContactNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        assertDoesNotThrow(() -> {
            addressBook.addContact(mockContact1);
            addressBook.addContact(mockContact2);
            addressBook.addContact(mockContact3);
        });

        // Act - Input what phone number to search
        Contacts result = addressBook.searchContactByPhoneNumber("1234567890");

        // Assert
        assertEquals("1234567890", result.getPhoneNumber(), "Returned contact phone number should equal search number");
    }

    // User Story 10: As an end user, I want an exception to throw if my search returns null, so I know my input is incorrect
    @Test
    @DisplayName("Search contact by name throws exception when contact not found")
    void testSearchContactByNameThrowsException() {
        // Arrange
        AddressBook addressBook = new AddressBook();

        // Act
        Exception e = assertThrows(ContactNotFoundException.class, () -> {
            addressBook.searchContactByName("Jane Doe"); // User Input mock name
        });

        // Assert
        assertEquals("Contact with name 'Jane Doe' not found in address book", e.getMessage());
    }

    @Test
    @DisplayName("Search contact by email throws exception when contact not found")
    void testSearchContactByEmailThrowsException() {
        // Arrange
        AddressBook addressBook = new AddressBook();

        // Act
        Exception e = assertThrows(ContactNotFoundException.class, () -> {
            addressBook.searchContactByEmail("janed@gmail.com"); // User Input mock name
        });

        // Assert
        assertEquals("Contact with email 'janed@gmail.com' not found in address book", e.getMessage());
    }

    @Test
    @DisplayName("Search contact by phone number throws exception when contact not found")
    void testSearchContactByPhoneNumberThrowsException() {
        // Arrange
        AddressBook addressBook = new AddressBook();

        // Act
        Exception e = assertThrows(ContactNotFoundException.class, () -> {
            addressBook.searchContactByPhoneNumber("1234567890"); // User Input mock name
        });

        // Assert
        assertEquals("Contact with phone number '1234567890' not found in address book", e.getMessage());
    }


    // User Story 11: As an end user, I want to edit existing contact details, so that the information stays relevant.
    @Test
    @DisplayName("Edit the name of the last contact in a mock array")
    void testEditContactName() throws IncompleteContactException, ContactNotFoundException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts contact1 = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");
        Contacts contact2 = new Contacts("Betty Boop", "bettyb@gmail.com", "1212121212");
        Contacts contact3 = new Contacts("Ciara Carrot", "ciarac@gmail.com", "0987654321");

        // Act
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        String oldName = contact3.getName(); // Stores original name in variable
        addressBook.editContactName("Ciara Carrot", "Ciara Smith");

        // Assert - Use for loop to iterate over Contacts
        for (Contacts updatedContact : addressBook.getContacts()) {
            if (updatedContact.getName().equals("Ciara Smith")) { // if statement checks if name matches "Ciara Smith"
                assertEquals("Ciara Smith", updatedContact.getName());
                System.out.printf("Original name: " + oldName + "%nUpdated name: " + updatedContact.getName());
                return;
            }
        }
        fail("Unable to find contact matching 'Ciara Smith'.");
    }

    @Test
    @DisplayName("Edit the email of the second contact in a mock array")
    void testEditContactEmail() throws IncompleteContactException, ContactNotFoundException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts contact1 = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");
        Contacts contact2 = new Contacts("Betty Boop", "bettyb@gmail.com", "1212121212");

        // Act
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        String oldEmail = contact2.getEmail(); // Stores original email in variable
        addressBook.editContactEmail("bettyb@gmail.com", "newemail@gmail.com");

        // Assert - Use for loop to iterate over Contacts
        for (Contacts updatedContact : addressBook.getContacts()) {
            if (updatedContact.getEmail().equals("newemail@gmail.com")) { // if statement checks if email matches "newemail@gmail.com"
                assertEquals("newemail@gmail.com", updatedContact.getEmail());
                System.out.printf("Original email: " + oldEmail + "%nUpdated email: " + updatedContact.getEmail());
                return;
            }
        }
        fail("Unable to find contact matching 'newemail@gmail.com'.");
    }

    @Test
    @DisplayName("Edit the phone number of the first contact in a mock array")
    void testEditContactPhoneNumber() throws IncompleteContactException, ContactNotFoundException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding contact (already know multiple work)
        AddressBook addressBook = new AddressBook();
        Contacts contact1 = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");

        // Act
        addressBook.addContact(contact1);
        String oldPhoneNumber = contact1.getPhoneNumber(); // Stores original email in variable
        addressBook.editContactPhoneNumber("1234567890", "0987654321");

        // Assert - Use for loop to iterate over Contact(s)
        for (Contacts updatedContact : addressBook.getContacts()) {
            if (updatedContact.getPhoneNumber().equals("0987654321")) { // if statement checks if phone matches "0987654321"
                assertEquals("0987654321", updatedContact.getPhoneNumber());
                System.out.printf("Original phone number: " + oldPhoneNumber + "%nUpdated phone number: " + updatedContact.getPhoneNumber());
                return;
            }
        }
        fail("Unable to find contact matching '0987654321'.");
    }

    // User Story 12: As an end user, I want to remove an existing contact from the address book, so that I can no longer view their details.
    @Test
    @DisplayName("Remove an existing contact from address book")
    void removeContact() throws IncompleteContactException, ContactNotFoundException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);
        Contacts mockContact3 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        when(mockContact3.getName()).thenReturn("Ciara Carrot");
        when(mockContact3.getEmail()).thenReturn("ciarac@gmail.com");
        when(mockContact3.getPhoneNumber()).thenReturn("0987654321");

        addressBook.addContact(mockContact1);
        addressBook.addContact(mockContact2);
        addressBook.addContact(mockContact3);

        // Verify mockContact3 is in arrayList before removing
        assertTrue(addressBook.getContacts().contains(mockContact3));

        // Act
        addressBook.removeContact("Ciara Carrot");

        // Assert - Check no mockContact3 in address book after removeContact
        assertFalse(addressBook.getContacts().contains(mockContact3));
    }

    @Test
    @DisplayName("Exception when non-existent contact removed from address book")
    void removeNonExistentContact() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        addressBook.addContact(mockContact1);
        addressBook.addContact(mockContact2);

        // Act - Expect exception when trying to remove a non-existing contact
        Exception e = assertThrows(ContactNotFoundException.class, () -> {
            addressBook.removeContact("Jane Doe");
        });

        // Assert
        assertEquals("Contact with name 'Jane Doe' not found in address book", e.getMessage());
    }

    @Test
    @DisplayName("Exception when remove a contact from empty address book")
    void removeContactEmptyAddressBook() {
        // Arrange - Creating an empty address book
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = mock(Contacts.class);
        when(mockContact.getName()).thenReturn(null);

        // Act - Expect exception when trying to remove a contact from an empty address book
        Exception e = assertThrows(ContactNotFoundException.class, () -> {
            addressBook.removeContact("Ciara Carrot");
        });

        // Assert
        assertEquals("Contact with name 'Ciara Carrot' not found in address book", e.getMessage());
    }

    // User Story 13-14: As an end user, I want to be unable to add a duplicate email, phone number, so that my book remains organised.
    @Test
    @DisplayName("Exception when duplicate email added to address book")
    void testDuplicateEmail() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        addressBook.addContact(mockContact1);
        //addressBook.addContact(mockContact2); not needed

        // Act - Expect exception when trying to add a duplicate email
        DuplicateContactException e = assertThrows(DuplicateContactException.class, () -> {
            addressBook.addContact(mockContact2);
        });

        // Assert
        assertEquals("Contact with email 'adama@gmail.com' already exists in address book", e.getMessage());
    }

    @Test
    @DisplayName("Adding a contact with a duplicate email does not modify the address book")
    void testDuplicateEmailDoesNotModifyAddressBook() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1212121212");

        addressBook.addContact(mockContact1);

        // Act - Should have added try-catch in AddressBook but too late now
        try {
            addressBook.addContact(mockContact2);
        } catch (DuplicateContactException | InvalidPhoneNumberException ignored) {
        }

        // Assert
        assertFalse(addressBook.getContacts().contains(mockContact2));
    }

    @Test
    @DisplayName("Exception when duplicate phone number added to address book")
    void testDuplicatePhoneNumber() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding multiple contacts
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1234567890");

        addressBook.addContact(mockContact1);

        // Act - Expect exception when trying to add a duplicate phone no
        DuplicateContactException e = assertThrows(DuplicateContactException.class, () -> {
            addressBook.addContact(mockContact2);
        });

        // Assert
        assertEquals("Contact with phone number '1234567890' already exists in address book", e.getMessage());
    }

    @Test
    @DisplayName("Adding a contact with a duplicate phone number does not modify the address book")
    void testDuplicatePhoneNumberDoesNotModifyAddressBook() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts mockContact1 = mock(Contacts.class);
        Contacts mockContact2 = mock(Contacts.class);

        when(mockContact1.getName()).thenReturn("Adam Appleton");
        when(mockContact1.getEmail()).thenReturn("adama@gmail.com");
        when(mockContact1.getPhoneNumber()).thenReturn("1234567890");

        when(mockContact2.getName()).thenReturn("Betty Boop");
        when(mockContact2.getEmail()).thenReturn("bettyb@gmail.com");
        when(mockContact2.getPhoneNumber()).thenReturn("1234567890");

        addressBook.addContact(mockContact1);

        // Act - Should have added try-catch in AddressBook but too late now
        try {
            addressBook.addContact(mockContact2);
        } catch (DuplicateContactException ignored) {
        }

        // Assert
        assertFalse(addressBook.getContacts().contains(mockContact2));
    }

    @Test
    @DisplayName("Allows duplicate names to be added to the AddressBook")
    void testAddContactWithDuplicateNames() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contacts contact1 = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");
        Contacts contact2 = new Contacts("Adam Appleton", "adamb@gmail.com", "0987654321");

        // Act
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        // Assert
        assertTrue(addressBook.getContacts().contains(contact1));
        assertTrue(addressBook.getContacts().contains(contact2));
    }

// 15 - As an end user, I want to have the new/edited email validated, so that the address book is uniform
    @Test
    @DisplayName("Exception when invalid email added to address book")
    void testInvalidEmail()  {
        // Arrange - Adding contact with invalid email
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = new Contacts("Adam Appleton", "invalidemail", "1234567890");

        // Act - Expect exception when trying to add an invalid email
        InvalidEmailException e = assertThrows(InvalidEmailException.class, () -> {
            addressBook.addContact(mockContact);
        });

        // Assert
        assertEquals("Email 'invalidemail' not valid", e.getMessage());
    }

    @Test
    @DisplayName("Exception when editing an existing contact's email to an invalid email")
    void testEditContactWithInvalidEmail() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding a contact
        AddressBook addressBook = new AddressBook();
        Contacts contact = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");
        addressBook.addContact(contact);

        // Act - Expect exception when trying to edit a contact with an invalid email
        InvalidEmailException e = assertThrows(InvalidEmailException.class, () -> {
            addressBook.editContactEmail("adama@gmail.com", "invalidemail");
        });

        // Assert
        assertEquals("Email 'invalidemail' not valid", e.getMessage());
    }

    // 16 - As an end user, I want to have the new/edited phone number validated, so that the address book is uniform
    @Test
    @DisplayName("Exception when invalid phone added to address book")
    void testInvalidPhone()  {
        // Arrange - Adding contact with invalid phone
        AddressBook addressBook = new AddressBook();
        Contacts mockContact = new Contacts("Adam Appleton", "adama@gmail.com", "123");

        // Act - Expect exception when trying to add an invalid email
        InvalidPhoneNumberException e = assertThrows(InvalidPhoneNumberException.class, () -> {
            addressBook.addContact(mockContact);
        });

        // Assert
        assertEquals("Phone number '123' not valid", e.getMessage());
    }

    @Test
    @DisplayName("Exception when editing an existing contact's phone number to an invalid number")
    void testEditContactWithInvalidPhone() throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        // Arrange - Adding a contact
        AddressBook addressBook = new AddressBook();
        Contacts contact = new Contacts("Adam Appleton", "adama@gmail.com", "1234567890");
        addressBook.addContact(contact);

        // Act - Expect exception when trying to edit a contact with an invalid email
        InvalidPhoneNumberException e = assertThrows(InvalidPhoneNumberException.class, () -> {
            addressBook.editContactPhoneNumber("1234567890", "456");
        });

        // Assert
        assertEquals("Phone number '456' not valid", e.getMessage());
    }
}


package com.digitalfuturesacademy.app;

import java.util.ArrayList; // import the ArrayList class

public class AddressBook {
    ArrayList<Contacts> contacts = new ArrayList<>(); // Create an ArrayList object called contacts to store the contacts in the Contacts class

    public void addContact(Contacts contact) throws IncompleteContactException, DuplicateContactException, InvalidEmailException, InvalidPhoneNumberException {
        if (contact.getName() == null || contact.getName().isEmpty() ||
                contact.getEmail() == null || contact.getEmail().isEmpty() ||
                contact.getPhoneNumber() == null || contact.getPhoneNumber().isEmpty()) {
            throw new IncompleteContactException("All contact details must be provided (name, email, phone number)");
        }
        if (!isValidEmail(contact.getEmail())) {
            throw new InvalidEmailException("Email '" + contact.getEmail() + "' not valid");
        }
        if (!isValidPhoneNumber(contact.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Phone number '" + contact.getPhoneNumber() + "' not valid");
        }

        for (Contacts existingContact : contacts) {
            if (existingContact.getEmail().equals(contact.getEmail())) {
                throw new DuplicateContactException("Contact with email '" + contact.getEmail() + "' already exists in address book");
            }

            if (existingContact.getPhoneNumber().equals(contact.getPhoneNumber())) {
                throw new DuplicateContactException("Contact with phone number '" + contact.getPhoneNumber() + "' already exists in address book");
            }
        }
        contacts.add(contact);
    }

    private boolean isValidEmail(String email) { // Checks if email valid before adding to address book
        return email.contains("@");
    }

    private boolean isValidPhoneNumber(String phoneNumber) { // Checks if phone no valid before adding to address book
        String regex = "^[0-9]{10}$"; // Checks String is exactly 10 digits
        return phoneNumber.matches(regex);
    }

    // Method to search through contacts by name
    public Contacts searchContactByName(String name) throws ContactNotFoundException {
        for (Contacts contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact with name '" + name + "' not found in address book");
    }

    // Method to search through contacts by email
    public Contacts searchContactByEmail(String email) throws ContactNotFoundException {
        for (Contacts contact : contacts) {
            if (contact.getEmail().equals(email)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact with email '" + email + "' not found in address book");

    }

    // Method to search through contacts by phone number
    public Contacts searchContactByPhoneNumber(String phoneNumber) throws ContactNotFoundException {
        for (Contacts contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact with phone number '" + phoneNumber + "' not found in address book");
    }

    // Method to edit contact name
    public void editContactName(String oldName, String newName) throws IncompleteContactException, ContactNotFoundException {
        if (newName == null) {
            throw new IncompleteContactException("New name must not be empty");
        }
        for (Contacts contact : contacts) {
            if (contact.getName().equals(oldName)) {
                contact.setName(newName);
                return;
            }
        }
        throw new ContactNotFoundException("Contact with name '" + oldName + "' not found in address book");
    }

    // Method to edit contact email
    public void editContactEmail(String oldEmail, String newEmail) throws IncompleteContactException, ContactNotFoundException, InvalidEmailException {
        if (newEmail == null) {
            throw new IncompleteContactException("New email must not be empty");
        }
        if (!isValidEmail(newEmail)) {
            throw new InvalidEmailException("Email '" + newEmail + "' not valid");
        }
        for (Contacts contact : contacts) {
            if (contact.getEmail().equals(oldEmail)) {
                contact.setEmail(newEmail);
                return;
            }
        }
        throw new ContactNotFoundException("Contact with email '" + oldEmail + "' not found in address book");
    }

    // Method to edit contact phone number
    public void editContactPhoneNumber(String oldPhoneNumber, String newPhoneNumber) throws IncompleteContactException, ContactNotFoundException, InvalidPhoneNumberException {
        if (newPhoneNumber == null) {
            throw new IncompleteContactException("New phone number must not be empty");
        }
        if (!isValidPhoneNumber(newPhoneNumber)) {
            throw new InvalidPhoneNumberException("Phone number '" + newPhoneNumber + "' not valid");
        }
        for (Contacts contact : contacts) {
            if (contact.getPhoneNumber().equals(oldPhoneNumber)) {
                contact.setPhoneNumber(newPhoneNumber);
                return;
            }
        }
        throw new ContactNotFoundException("Contact with phone number '" + oldPhoneNumber + "' not found in address book");
    }

    public void removeContact(String name) throws ContactNotFoundException {
        Contacts contactToRemove = null;
        for (Contacts contact : contacts) {
            if (contact.getName().equals(name)) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
        } else {
            throw new ContactNotFoundException("Contact with name '" + name + "' not found in address book");
        }
    }

    public ArrayList<Contacts> getContacts() { // Method to get the contacts from the Contacts class
        return contacts;
    }
}

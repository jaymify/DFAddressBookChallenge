package com.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IncompleteContactException, ContactNotFoundException, InvalidEmailException, InvalidPhoneNumberException {
        AddressBook addressBook = new AddressBook(); // Create an AddressBook object called addressBook
        Scanner scanner = new Scanner(System.in); // Create scanner object to read user input

        // Main loop for user input
        while (true) {
            System.out.println("Please select an option: \n1. Add new contact \n2. Edit contact \n3. Remove contact\n4. Search contact  \n5. View all contacts \n6. Exit program");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline char

            switch (option) {
                // Add new contact
                case 1:
                    System.out.println("Enter new contact name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter new contact email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter new contact phone number: ");
                    String phoneNumber = scanner.nextLine();

                    // Handles potential exceptions thrown by AddressBook methods
                    try {
                        Contacts contact = new Contacts(name, email, phoneNumber);
                        addressBook.addContact(contact);
                        ArrayList<Contacts> contacts = addressBook.getContacts();

                        System.out.println(contacts.get(0).getName());
                    } catch (IncompleteContactException | DuplicateContactException | InvalidEmailException |
                             InvalidPhoneNumberException e) {
                        e.printStackTrace();
                    }
                    break;

                // Edit existing contact
                case 2:
                    System.out.println("What would you like to edit? \n1. Name\n2. Email\n3. Phone number");
                    int editOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (editOption) {
                        case 1:
                            System.out.println("Enter the name of the contact you want to edit: ");
                            String oldName = scanner.nextLine();
                            System.out.println("Enter the new name: ");
                            String newName = scanner.nextLine();
                            addressBook.editContactName(oldName, newName);
                            break;
                        case 2:
                            System.out.println("Enter the email of the contact you want to edit: ");
                            String oldEmail = scanner.nextLine();
                            System.out.println("Enter the new email: ");
                            String newEmail = scanner.nextLine();
                            addressBook.editContactEmail(oldEmail, newEmail);
                            break;
                        case 3:
                            System.out.println("Enter the phone number of the contact you want to edit: ");
                            String oldPhoneNumber = scanner.nextLine();
                            System.out.println("Enter the new phone number: ");
                            String newPhoneNumber = scanner.nextLine();
                            addressBook.editContactPhoneNumber(oldPhoneNumber, newPhoneNumber);
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                            break;
                    }
                    break;

                // Remove existing contact
                case 3:
                    System.out.println("Enter contact name to be removed: ");
                    String contactToRemove = scanner.nextLine();

                    // Handles potential exceptions thrown by AddressBook methods
                    try {
                        addressBook.removeContact(contactToRemove);
                    } catch (ContactNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                // Search existing contacts
                case 4:
                    System.out.println("What would you like to search by? \n1. Name\n2. Email\n3. Phone number");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine();

                    // Handles potential exceptions thrown by AddressBook methods
                    try {
                        switch (searchOption) {
                            case 1:
                                System.out.println("Enter name: ");
                                String SearchName = scanner.nextLine();
                                Contacts contactByName = addressBook.searchContactByName(SearchName);
                                System.out.println("Contact found: " + contactByName.getName() + " " + contactByName.getEmail() + " " + contactByName.getPhoneNumber());
                                break;
                            case 2:
                                System.out.println("Enter email: ");
                                String SearchEmail = scanner.nextLine();
                                Contacts contactByEmail = addressBook.searchContactByEmail(SearchEmail);
                                System.out.println("Contact found: " + contactByEmail.getName() + " " + contactByEmail.getEmail() + " " + contactByEmail.getPhoneNumber());
                                break;
                            case 3:
                                System.out.println("Enter phone number: ");
                                String SearchPhoneNumber = scanner.nextLine();
                                Contacts contactByPhoneNumber = addressBook.searchContactByPhoneNumber(SearchPhoneNumber);
                                System.out.println("Contact found: " + contactByPhoneNumber.getName() + " " + contactByPhoneNumber.getEmail() + " " + contactByPhoneNumber.getPhoneNumber());
                                break;
                            default:
                                System.out.println("Invalid option. Please choose a valid option.");
                                break;
                        }
                    } catch (ContactNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // View all contacts
                case 5:
                    ArrayList<Contacts> contacts = addressBook.getContacts();
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    }
                    for (Contacts contact : contacts) {
                        System.out.println("Name: " + contact.getName() + ", Email: " + contact.getEmail() + ", Phone Number: " + contact.getPhoneNumber());
                    }
                    break;

                // Exit the program
                case 6:
                    System.out.println("Exiting the program...");
                    return;

                // Handles invalid user input
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}

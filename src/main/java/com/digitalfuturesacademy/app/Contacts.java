package com.digitalfuturesacademy.app;

public class Contacts {
    private String name;
    private String email;
    private String phoneNumber;

    public Contacts(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { // Method to get the name of the contact
        return name;
    }

    public String getEmail() { // Method to get the email of the contact
        return email;
    }

    public String getPhoneNumber() { // Method to get the phone number of the contact
        return phoneNumber;
    }

    // Update the contact details
    public void setName(String newName) {
        this.name = newName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
}

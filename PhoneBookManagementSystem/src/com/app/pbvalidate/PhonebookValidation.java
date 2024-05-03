package com.app.pbvalidate;

import java.util.List;

import com.app.phonebook.PhoneBook;
import com.contact.Contact;

public class PhonebookValidation {
	public void displayAll(PhoneBook phoneBook) {
        System.out.println("All contacts:");
        for (Contact contact : phoneBook.getAllContacts()) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmail());
        }
    }

    public void sortContacts(PhoneBook phoneBook) {
        phoneBook.sortContactsByName();
        System.out.println("Contacts sorted by name:");
        displayAll(phoneBook);
    }

    public void removeContact(PhoneBook phoneBook, String name) {
        List<Contact> contacts = phoneBook.getAllContacts();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                phoneBook.removeContact(contact);
                System.out.println("Contact '" + name + "' removed.");
                return;
            }
        }
        System.out.println("Contact '" + name + "' not found.");
    }
}

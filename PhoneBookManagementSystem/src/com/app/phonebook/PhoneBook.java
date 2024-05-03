package com.app.phonebook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.PBExceptionhandle.PBxeceptionhandle;
import com.app.pbvalidate.PhonebookValidation;
import com.contact.Contact;
import com.pbexception.PBException;

public class PhoneBook{
	private List<Contact> contacts;

	public PhoneBook() {
		contacts = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}

	public List<Contact> getAllContacts() {
		return contacts;
	}

	public void sortContactsByName() {
		Collections.sort(contacts, Comparator.comparing(Contact::getName));
	}

	public static void main(String[] args) {

		PhoneBook phoneBook = new PhoneBook();
		PhonebookValidation validator = new PhonebookValidation();
		Scanner scanner = new Scanner(System.in);

		int choice;
		do {
			System.out.println("PhoneBook Menu:");
			System.out.println("1. Add contact");
			System.out.println("2. Show all contacts");
			System.out.println("3. Remove contact");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
			case 1:
				// Adding a contact
				try {
					System.out.print("Enter phone number (10 digits): ");
					String phoneNumberStr = scanner.nextLine();
					if (phoneNumberStr.length() != 10) {
						throw new PBxeceptionhandle("Invalid phone number format. Please enter a 10-digit number.");
					}
					if (!phoneNumberStr.matches("\\d+")) {
						throw new PBxeceptionhandle("Phone number must contain only digits.");
					}
					int phoneNumber = Integer.parseInt(phoneNumberStr);
					System.out.print("Enter name: ");
					String name = scanner.nextLine();
					System.out.print("Enter date of birth (yyyy-mm-dd): ");
					String dobString = scanner.nextLine();
					LocalDate dob = LocalDate.parse(dobString);
					System.out.print("Enter email: ");
					String email = scanner.nextLine();

					phoneBook.addContact(new Contact(phoneNumber, name, dob, email));
					System.out.println("Contact added successfully.");
				} catch (PBxeceptionhandle e) {
					System.out.println("Error adding contact: " + e.getMessage());
				} catch (PBException e) {
					System.out.println("Error adding contact: " + e.getMessage());
				}
				break;
			case 2:
				// Display all contacts
				validator.displayAll(phoneBook);
				break;
			case 3:
				// Remove a contact
				System.out.print("Enter name of contact to remove: ");
				String nameToRemove = scanner.nextLine();
				validator.removeContact(phoneBook, nameToRemove);
				break;
			case 4:
				// Exit the program
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 4.");
			}
		} while (choice != 4);

		scanner.close();
	}
}






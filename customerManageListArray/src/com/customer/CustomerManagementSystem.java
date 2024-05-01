package com.customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementSystem {
	 private static List<Customer> customers = new ArrayList<>();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("-------------------CUSTOMER-MANAGEMENT----------------------------");
	            System.out.println("1. Sign up");
	            System.out.println("2. Sign in");
	            System.out.println("3. Change password");
	            System.out.println("4. Unsubscribe customer");
	            System.out.println("5. Display all customers");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    signUp(scanner);
	                    break;
	                case 2:
	                    signIn(scanner);
	                    break;
	                case 3:
	                    changePassword(scanner);
	                    break;
	                case 4:
	                    unsubscribeCustomer(scanner);
	                    break;
	                case 5:
	                    displayAllCustomers();
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 0);

	        scanner.close();
	    }

	    private static void signUp(Scanner scanner) {
	        System.out.println("Enter first name:");
	        String firstName = scanner.next();
	        System.out.println("Enter last name:");
	        String lastName = scanner.next();
	        System.out.println("Enter email:");
	        String email = scanner.next();
	        System.out.println("Enter password:");
	        String password = scanner.next();
	        System.out.println("Enter registration amount:");
	        double registrationAmount = scanner.nextDouble();
	        System.out.println("Enter date of birth (yyyy-mm-dd):");
	        String dobString = scanner.next();
	        LocalDate dob = LocalDate.parse(dobString);
	        System.out.println("Enter plan (SILVER, GOLD, DIAMOND, PLATINUM):");
	        String planString = scanner.next().toUpperCase(); // Convert to uppercase
	        ServicePlans plan = ServicePlans.valueOf(planString);

	        try {
	            Customer customer = new Customer(firstName, lastName, email, password, registrationAmount, dob, plan);
	            customers.add(customer);
	            System.out.println("Customer registered successfully:\n" + customer);
	        } catch (CustomException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public static void signIn(Scanner scanner) {
	        System.out.println("Enter email:");
	        String email = scanner.next();
	        System.out.println("Enter password:");
	        String password = scanner.next();

	        Customer customer = findCustomerByEmail(email);
	        if (customer != null && customer.getPassword().equals(password)) {
	            System.out.println("Login successful.");
	        } else {
	            System.out.println("Invalid email or password.");
	        }
	    }

	    private static void changePassword(Scanner scanner) {
	        System.out.println("Enter email:");
	        String email = scanner.next();

	        try {
	            Customer customer = findCustomerByEmail(email);
	            if (customer == null) {
	                throw new CustomerNotFoundException("Customer with email '" + email + "' not found.");
	            }

	            System.out.println("Enter old password:");
	            String oldPassword = scanner.next();
	            if (!customer.getPassword().equals(oldPassword)) {
	                throw new CustomerNotFoundException("Incorrect password for customer with email '" + email + "'.");
	            }

	            System.out.println("Enter new password:");
	            String newPassword = scanner.next();

	            customer.setPassword(newPassword);
	            System.out.println("Password updated successfully.");
	        } catch (CustomerNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public static void unsubscribeCustomer(Scanner scanner) {
	        System.out.println("Enter email:");
	        String email = scanner.next();

	        Customer customer = findCustomerByEmail(email);
	        if (customer != null) {
	            customers.remove(customer);
	            System.out.println("Customer unsubscribed successfully.");
	        } else {
	            System.out.println("Customer not found.");
	        }
	    }

	    private static void displayAllCustomers() {
	        System.out.println("All Customers:");
	        for (Customer customer : customers) {
	            System.out.println(customer);
	        }
	    }

	    public static Customer findCustomerByEmail(String email) {
	        for (Customer customer : customers) {
	            if (customer.getEmail().equals(email)) {
	                return customer;
	            }
	        }
	        return null;
	    }
}

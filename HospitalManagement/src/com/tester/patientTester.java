package com.tester;
import static com.utils.PatientUtils.*;
import java.util.Map;
import java.util.Scanner;
import static com.validation.PatientValidation.*;
import com.app.patient.Patient;

public class patientTester {

	public static void main(String[] args) {
		  try (Scanner sc = new Scanner(System.in)) {
	            boolean exit = false;
	          
	            Map<String, Patient> patientsMap = populateHM();
	            while (!exit) {
	                System.out.println(
	                        "Options:\n1. Patient Registration\n2. Display All Patients\n3. Login\n4. Change Password\n5. Unsubscribe\n6. Sorting Customers by Date of Birth\n7. Sorting Customers by Date of Birth and Service Plan\n8. Enter Email to Remove Customer\n9. Sort by Date of Birth and Last Name\n10. Sorting Customers by Email\n11.Customers sorted by ID\n12.Customers sorted by Plan\n");
	                System.out.println("Choose an option:");

	                try {
	                    switch (sc.nextInt()) {
	                    case 1:
	                        System.out.println(
	                                "Enter customer details: firstName, lastName, email, password, regAmount, dob, plan");
	                        Patient patient = 
	                        		patientsMap.put(patient.getEmail(),patient);
	                        System.out.println("Patient registered successfully.");
	                        break;

	                    case 2:
	                        System.out.println("All Customers:");
	                        patientsMap.values().forEach(System.out::println);
	                        break;

	                    case 3:
	                        System.out.println("Enter email and password:");
	                        Patient authenticatedPatient = authenticatePatient(sc.next(), sc.next(), patientsMap);
	                        System.out.println("Successful login, your details: " + authenticatedPatient);
	                        break;

	                    case 4:
	                        System.out.println("Enter email, old password, and new password:");
	                        String email = sc.next();
	                        String oldPassword = sc.next();
	                        Patient patientToChangePassword = authenticatePatient(email, oldPassword, patientsMap);
	                        System.out.println("Enter new password:");
	                        String newPassword = sc.next();
	                        patientToChangePassword.setPassword(newPassword);
	                        
	                        System.out.println("Password changed successfully.");
	                        break;
	                    default:
	                        System.out.println("Invalid option.");
	                        break;
	                    }
	                  }catch (Exception e) {
	                    System.out.println(e.getMessage());
	                }
	            }
	        }
	    }


	}



package com.contact;
import java.time.LocalDate;

import com.pbexception.PBException;
public class Contact {
	  private int phoneNumber;
	    private String name;
	    private LocalDate dob;
	    private String email;

	    public Contact(int phoneNumber, String name, LocalDate dob, String email) throws PBException {
	        if (phoneNumber <= 0) {
	            throw new PBException("Invalid phone number");
	        }
	        if (name == null || name.trim().isEmpty()) {
	            throw new PBException("Name cannot be empty");
	        }
	        if (dob == null) {
	            throw new PBException("Date of birth cannot be null");
	        }
	        if (email == null || !email.contains("@")) {
	            throw new PBException("Invalid email address");
	        }

	        this.phoneNumber = phoneNumber;
	        this.name = name;
	        this.dob = dob;
	        this.email = email;
	    }

	    public int getPhoneNumber() {
	        return phoneNumber;
	    }

	    public String getName() {
	        return name;
	    }

	    public LocalDate getDob() {
	        return dob;
	    }

	    public String getEmail() {
	        return email;
	    }
}

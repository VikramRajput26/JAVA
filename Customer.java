package com.cust.management;

import java.time.LocalDate;

public class Customer {
	  private static int customerIdCounter = 1;

	    private int customerId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private double registrationAmount;
	    private LocalDate dob;
	    private ServicePlans plan;

	    public Customer(String firstName, String lastName, String email, String password, double registrationAmount, LocalDate dob, ServicePlans plan) throws CustomException {
	        if (CustomerManagementSystem.findCustomerByEmail(email) != null) {
	            throw new CustomException("Customer with email '" + email + "' already exists.");
	        }
	        this.customerId = customerIdCounter++;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	        this.registrationAmount = registrationAmount;
	        this.dob = dob;
	        this.plan = plan;
	    }
	    
	    

		@Override
		public String toString() {
			return "Customer [customerId= " + customerId + ", firstName= " + firstName + ", lastName=" + lastName
					+ ", email=" + email + ", password=" + password + ", registrationAmount=" + registrationAmount
					+ ", dob=" + dob + ", plan=" + plan + "]";
		}



		public static int getCustomerIdCounter() {
			return customerIdCounter;
		}

		public static void setCustomerIdCounter(int customerIdCounter) {
			Customer.customerIdCounter = customerIdCounter;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public double getRegistrationAmount() {
			return registrationAmount;
		}

		public void setRegistrationAmount(double registrationAmount) {
			this.registrationAmount = registrationAmount;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public ServicePlans getPlan() {
			return plan;
		}

		public void setPlan(ServicePlans plan) {
			this.plan = plan;
		}


		

}

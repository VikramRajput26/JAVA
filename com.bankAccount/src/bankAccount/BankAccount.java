package bankAccount;

import java.time.LocalDate;
import java.util.Date;

public class BankAccount {
	  private int accountNumber;
	    private String firstName;
	    private String lastName;
	    private AccountType accountType;
	    private LocalDate dateOfBirth;
	    private LocalDate dateCreated;
	    private double balance;

	    // Constructor
	    public BankAccount(int accountNumber, String firstName, String lastName, AccountType accountType,
	                       LocalDate dateOfBirth, LocalDate dateCreated, double balance) {
	        this.accountNumber = accountNumber;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.accountType = accountType;
	        this.dateOfBirth = dateOfBirth;
	        this.dateCreated = dateCreated;
	        this.balance = balance;
	    }

		@Override
		public String toString() {
			return "BankAccount [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", accountType=" + accountType + ", dateOfBirth=" + dateOfBirth + ", dateCreated=" + dateCreated
					+ ", balance=" + balance + "]";
		}

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
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

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public LocalDate getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDate dateCreated) {
			this.dateCreated = dateCreated;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

}

package bankAccount;

import java.time.LocalDate;

public class bankValidation {

	public static final double MINIMUMBALANCE;
	
	static {
		MINIMUMBALANCE=5000;
	}
	
	public static void validateBalance(double balance) throws BankException {
	    if (balance < MINIMUMBALANCE) {
	        throw new BankException("Your funds are reaching the lower limit.");
	    }
	    System.out.println("Valid balance.");
	}

	
	public static BankAccount validateInputs(int accountNumber, String firstName, String lastName, String accountType,
        CharSequence dateOfBirth, CharSequence dateCreated, double balance) throws BankException {
	AccountType accountType1= AccountType.valueOf(accountType.toUpperCase());
	LocalDate birthdate= LocalDate.parse(dateOfBirth);
	LocalDate crdate= LocalDate.parse(dateCreated);
	validateBalance(balance);
	return new BankAccount(accountNumber,firstName,lastName,accountType1,birthdate,crdate,balance);
		
}


}

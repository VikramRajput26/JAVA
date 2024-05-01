package bankAccount;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import static bankAccount.bankValidation.validateBalance;

public class bankUtility {

	  // Method to get current date in a specific format
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
    
    // Method to create a bank account using user input
    public static BankAccount createBankAccount(Scanner scanner) {
    	Scanner scanner1=new Scanner(System.in);
        System.out.println("\nEnter details for new account:");
        System.out.print("Enter account number: ");
        int accountNumber = scanner1.nextInt();

        System.out.print("Enter first name: ");
        String firstName = scanner1.next();

        System.out.print("Enter last name: ");
        String lastName = scanner1.next();

        System.out.print("Enter account type (SAVINGS or CHECKING): ");
        String accountTypeStr = scanner1.next();
        AccountType accountType = AccountType.valueOf(accountTypeStr.toUpperCase());

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dobStr = scanner1.next();
        LocalDate dateOfBirth = LocalDate.parse(dobStr);
        

        LocalDate currentDate = LocalDate.now(); // Current date
        double initialBalance = 0; // Initial balance

        return new BankAccount(accountNumber, firstName, lastName, accountType, dateOfBirth, currentDate, initialBalance);
    }

   

	// Method to display account information
    public static void displayAccountInfo(BankAccount[] accounts, int numAccounts) {
        if (numAccounts == 0) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\nAccount Information:");
        for (int i = 0; i < numAccounts; i++) {
            BankAccount account = accounts[i];
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("First Name: " + account.getFirstName());
            System.out.println("Last Name: " + account.getLastName());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Date of Birth: " + account.getDateOfBirth());
            System.out.println("Date Created: " + account.getDateCreated());
            System.out.println("Balance: " + account.getBalance());
            System.out.println();
        }
    }

    // Method to deposit into an account
    public static void deposit(BankAccount[] accounts, int numAccounts, Scanner scanner) {
        System.out.print("Enter account number to deposit into: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = findAccount(accounts, numAccounts, accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    

    public static void withdraw(BankAccount[] accounts, int numAccounts, Scanner scanner) throws BankException {
        System.out.print("Enter account number to withdraw from: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = bankUtility.findAccount(accounts, numAccounts, accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
                // Validate the new balance after withdrawal
                validateBalance(account.getBalance() - amount);
                // Update the balance
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } 
        } 
 



    // Method to check balance of an account
    public static void checkBalance(BankAccount[] accounts, int numAccounts, Scanner scanner) {
        System.out.print("Enter account number to check balance: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = findAccount(accounts, numAccounts, accountNumber);
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to find an account by its account number
    public static BankAccount findAccount(BankAccount[] accounts, int numAccounts, int accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            BankAccount account = accounts[i];
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

}

package bankAccount;

import java.time.LocalDate;
import java.util.Scanner;

public class Client {
	 public static void main(String[] args) {
	        try {
	            Scanner sc = new Scanner(System.in);
	            final int MAX_ACCOUNTS = 100;
	            BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
	            int numAccounts = 0;

	            int choice;
	            do {
	                System.out.println("\nBank Application Menu:");
	                System.out.println("1. Open new account");
	                System.out.println("2. Display account information");
	                System.out.println("3. Deposit");
	                System.out.println("4. Withdraw");
	                System.out.println("5. Check balance");
	                System.out.println("6. Exit");
	                System.out.print("Enter your choice: ");
	                choice = sc.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter how many accounts you want to open: ");
	                        int numNewAccounts = sc.nextInt();
	                        for (int i = 0; i < numNewAccounts; i++) {
	                            if (numAccounts < MAX_ACCOUNTS) {
	                                BankAccount account = createBankAccount(sc);
	                                accounts[numAccounts] = account;
	                                numAccounts++;
	                            } else {
	                                System.out.println("Maximum number of accounts reached.");
	                                break;
	                            }
	                        }
	                        break;
	                    case 2:
	                   bankUtility.displayAccountInfo(accounts, numAccounts);
	                        break;
	                    case 3:
	                        deposit(accounts, numAccounts, sc);
	                        break;
	                    case 4:
	                        withdraw(accounts, numAccounts, sc);
	                        break;
	                    case 5:
	                        checkBalance(accounts, numAccounts, sc);
	                        break;
	                    case 6:
	                        System.out.println("Exiting...");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            } while (choice != 6);

	           
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }

	 public static BankAccount createBankAccount(Scanner sc) {
	        System.out.println("\nEnter details for new account:");
	        System.out.print("Enter account number: ");
	        int accountNumber = sc.nextInt();

	        System.out.print("Enter first name: ");
	        String firstName = sc.next();

	        System.out.print("Enter last name: ");
	        String lastName = sc.next();

	        System.out.print("SAVINGS, CURRENT, FD, LOAN, DMAT, NRE : ");
	        String accountTypeStr = sc.next();
	        AccountType accountType = AccountType.valueOf(accountTypeStr.toUpperCase());

	        System.out.print("Enter date of birth (yyyy-MM-dd): ");
	        String dobStr = sc.next();
	        LocalDate dateOfBirth = LocalDate.parse(dobStr);

	        LocalDate currentDate = LocalDate.now(); // Current date
	        double initialBalance = 0; // Initial balance

	        return new BankAccount(accountNumber, firstName, lastName, accountType, dateOfBirth, currentDate, initialBalance);
	    }

	    // Method to deposit into an account
	    public static void deposit(BankAccount[] accounts, int numAccounts, Scanner scanner) {
	        System.out.print("Enter account number to deposit into: ");
	        int accountNumber = scanner.nextInt();

	        BankAccount account = bankUtility.findAccount(accounts, numAccounts, accountNumber);
	        if (account != null) {
	            System.out.print("Enter amount to deposit: ");
	            double amount = scanner.nextDouble();
	            account.setBalance(account.getBalance() + amount);
	            System.out.println("Deposit successful. New balance: " + account.getBalance());
	        } else {
	            System.out.println("Account not found.");
	        }
	    }

	    // Method to withdraw from an account
	    public static void withdraw(BankAccount[] accounts, int numAccounts, Scanner scanner) {
	        System.out.print("Enter account number to withdraw from: ");
	        int accountNumber = scanner.nextInt();

	        BankAccount account = bankUtility.findAccount(accounts, numAccounts, accountNumber);
	        if (account != null) {
	            System.out.print("Enter amount to withdraw: ");
	            double amount = scanner.nextDouble();
	            if (amount <= account.getBalance()) {
	                account.setBalance(account.getBalance() - amount);
	                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
	            } else {
	                System.out.println("Insufficient funds.");
	            }
	        } else {
	            System.out.println("Account not found.");
	        }
	    }

	    // Method to check balance of an account
	    public static void checkBalance(BankAccount[] accounts, int numAccounts, Scanner scanner) {
	        System.out.print("Enter account number to check balance: ");
	        int accountNumber = scanner.nextInt();

	        BankAccount account = bankUtility.findAccount(accounts, numAccounts, accountNumber);
	        if (account != null) {
	            System.out.println("Current balance: " + account.getBalance());
	        } else {
	            System.out.println("Account not found.");
	        }
	    }
}

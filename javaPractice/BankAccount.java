package javaPractice;
import java.util.Scanner;
public class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating a new bank account
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name:");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        
        // Menu-driven interface
        int choice;
        do {
            System.out.println("\nBank Account Management System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
            
        } while (choice != 4);
        
        scanner.close();
    }
}

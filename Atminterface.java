import java.util.*;
import java.util.Scanner;

// class to represent the atm machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(double initialBalance) {
        bankAccount = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1.  To Check Balance");
            System.out.println("2. To Deposit");
            System.out.println("3. To Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Balance is : Rs " + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Please enter deposit amount here: Rs ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
// class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class Atminterface {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial bank balance
        ATM atm = new ATM(initialBalance);
        atm.run();
    }
}

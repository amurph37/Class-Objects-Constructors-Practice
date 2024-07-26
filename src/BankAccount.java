import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String accountHolderName;
    private String accountNumber;

    // Constructor with parameters
    public BankAccount(String name, double initialBalance, String accountNumber) {
        this.accountHolderName = name;
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    // Constructor with no parameters
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        this.accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        this.balance = scanner.nextDouble();
        System.out.print("Enter account number: ");
        this.accountNumber = scanner.next();
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. Current balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: $" + balance);
    }

    // Additional deposit method with account number validation
    public void deposit(double amount, String accountNumber) {
        if (amount > 0 && this.accountNumber.equals(accountNumber)) {
            balance += amount;
            System.out.println(amount + " deposited. Current balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive or account number mismatch.");
        }
    }

    // Additional withdrawal method with account number validation
    public void withdraw(double amount, String accountNumber) {
        if (amount > 0 && amount <= balance && this.accountNumber.equals(accountNumber)) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or account number mismatch.");
        }
    }

    // Method to transfer money
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to account " + targetAccount.getAccountNumber() + ". Current balance: " + balance);
        } else {
            System.out.println("Invalid transfer amount.");
        }
    }
}

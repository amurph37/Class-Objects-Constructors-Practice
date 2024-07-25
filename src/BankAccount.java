public class BankAccount {
    private double balance;
    private String accountHolderName;

    // Constructor
    public BankAccount(String name, double initialBalance) {
        this.accountHolderName = name;
        this.balance = initialBalance;
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
        System.out.println("Account Balance: $" + balance);
    }
}

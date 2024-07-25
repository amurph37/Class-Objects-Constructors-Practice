public class Main {
    public static void main(String[] args) {
        // Create two BankAccount objects
        BankAccount account1 = new BankAccount("Alice", 5000);
        BankAccount account2 = new BankAccount("Bob", 300);

        // Withdraw $100 from the first account
        account1.withdraw(100);

        // Deposit $100 into the second account
        account2.deposit(100);

        // Print account details for both accounts
        account1.printAccountDetails();
        account2.printAccountDetails();
    }
}

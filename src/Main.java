public class Main {
    public static void main(String[] args) {
        // Create two BankAccount objects
        BankAccount account1 = new BankAccount("Alice", 500);
        BankAccount account2 = new BankAccount("Bob", 5000);
        BankAccount account3 = new BankAccount("Charlie", 300);

        // Withdraw $100 from the first account
        account2.withdraw(100);

        // Deposit $100 into the second account
        account1.deposit(100);
        account3.deposit(100);

        // Print account details for both accounts
        account1.printAccountDetails();
        account2.printAccountDetails();
        account3.printAccountDetails();
    }
}

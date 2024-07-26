import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Greeting message
        System.out.println("Hello World, Welcome to the Bank of AJ!");

        // Create an ArrayList to keep track of bank accounts
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            System.out.print("Are you an existing customer? (1. Yes 2. No, -1 to exit): ");
            int choice = scanner.nextInt();

            if (choice == -1) {
                System.out.println("Thank you for visiting the Bank of AJ. Goodbye!");
                break;
            } else if (choice == 1) {
                // Existing customer logic
                if (accounts.isEmpty()) {
                    System.out.println("No existing accounts found.");
                } else {
                    System.out.println("Existing accounts:");
                    for (BankAccount account : accounts) {
                        account.printAccountDetails();
                    }
                    System.out.print("Enter your account number to proceed: ");
                    String accountNumber = scanner.next();
                    BankAccount currentAccount = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(accountNumber)) {
                            currentAccount = account;
                            break;
                        }
                    }
                    if (currentAccount != null) {
                        mainMenu(currentAccount, accounts, scanner);
                    } else {
                        System.out.println("Account number not found.");
                    }
                }
            } else if (choice == 2) {
                // New customer logic
                System.out.println("Let's make a new account!");
                scanner.nextLine(); // Consume the newline character

                System.out.print("What is the name for the account? ");
                String name = scanner.nextLine();

                System.out.print("What is the beginning balance for the account? ");
                double initialBalance = scanner.nextDouble();

                System.out.print("What is the account number? ");
                String accountNumber = scanner.next();

                // Create and add the new account
                BankAccount newAccount = new BankAccount(name, initialBalance, accountNumber);
                accounts.add(newAccount);

                System.out.println("Account created successfully!");
                newAccount.printAccountDetails();
                mainMenu(newAccount, accounts, scanner);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void mainMenu(BankAccount currentAccount, ArrayList<BankAccount> accounts, Scanner scanner) {
        System.out.println("Welcome, " + currentAccount.getAccountHolderName() + "!");

        while (true) {
            System.out.print("What would you like to do? (1. Check Balance 2. Deposit 3. Withdraw 4. Transfer 5. Exit): ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    currentAccount.printAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter the account number to transfer to: ");
                    String targetAccountNumber = scanner.next();
                    BankAccount targetAccount = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(targetAccountNumber)) {
                            targetAccount = account;
                            break;
                        }
                    }
                    if (targetAccount != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        currentAccount.transfer(targetAccount, transferAmount);
                    } else {
                        System.out.println("Target account number not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting to main menu.");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }
}

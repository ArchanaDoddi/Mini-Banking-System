import java.util.ArrayList;
import java.util.Scanner;

public class MiniBankingSystem {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Helper: find account by number
    private static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) return acc;
        }
        return null;
    }

    // Safe integer input
    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.nextLine(); // clear wrong input
            }
        }
    }

    // Safe double input
    private static double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a valid amount.");
                scanner.nextLine(); // clear wrong input
            }
        }
    }

    // 1. Create account
    private static void createAccount() {
        int accNo = getIntInput("Enter Account Number: ");
        scanner.nextLine(); // consume newline

        // Prevent duplicate accounts
        if (findAccount(accNo) != null) {
            System.out.println("❌ Account number already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int pin = getIntInput("Set a 4-digit PIN: ");
        if (pin < 1000 || pin > 9999) {
            System.out.println("❌ PIN must be 4 digits.");
            return;
        }

        Account newAcc = new Account(accNo, name, pin);
        accounts.add(newAcc);
        System.out.println("✅ Account created successfully!");
    }

    // 2. Deposit
    private static void depositMoney() {
        int accNo = getIntInput("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc != null) {
            double amount = getDoubleInput("Enter amount to deposit: ");
            acc.deposit(amount);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // 3. Withdraw
    private static void withdrawMoney() {
        int accNo = getIntInput("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc != null) {
            int pin = getIntInput("Enter PIN: ");
            double amount = getDoubleInput("Enter amount to withdraw: ");
            acc.withdraw(amount, pin);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // 4. View account
    private static void viewAccount() {
        int accNo = getIntInput("Enter Account Number: ");
        Account acc = findAccount(accNo);

        if (acc != null) {
            int pin = getIntInput("Enter PIN: ");
            acc.display(pin);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // Main menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Mini Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> viewAccount();
                case 5 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("❌ Invalid choice, try again.");
            }
        } while (choice != 5);
    }
}

public class Account {
    private int accountNumber;
    private String name;
    private double balance;
    private int pin;

    // Constructor
    public Account(int accountNumber, String name, int pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = 0.0; // default balance
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    // Deposit
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.println("✅ Deposited: " + amount + " | New Balance: " + balance);
    }

    // Withdraw
    public void withdraw(double amount, int enteredPin) {
        if (enteredPin != pin) {
            System.out.println("❌ Wrong PIN!");
            return;
        }
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be greater than 0.");
            return;
        }
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("✅ Withdrawn: " + amount + " | Remaining Balance: " + balance);
    }

    // Display details
    public void display(int enteredPin) {
        if (enteredPin != pin) {
            System.out.println("❌ Wrong PIN! Cannot show details.");
            return;
        }
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------");
    }
}

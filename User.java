// User class representing each user of the ATM
public class User {
    private String userID;
    private String userPIN;
    private double accountBalance;

    // Constructor
    public User(String userID, String userPIN, double accountBalance) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.accountBalance = accountBalance;
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getUserPIN() {
        return userPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposit successful. New balance: $" + accountBalance);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > accountBalance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + accountBalance);
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + accountBalance);
    }
}

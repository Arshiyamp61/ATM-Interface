import java.util.Scanner;

// ATM class encapsulating ATM functionalities
class ATM {
    private User currentUser;

    // Constructor
    public ATM(User currentUser) {
        this.currentUser = currentUser;
    }

    // Method for user authentication
    public boolean authenticateUser(String userID, String userPIN) {
        return currentUser.getUserID().equals(userID) && currentUser.getUserPIN().equals(userPIN);
    }

    // Method for withdrawing money
    public void withdraw(double amount) {
        currentUser.withdraw(amount);
    }

    // Method for depositing money
    public void deposit(double amount) {
        currentUser.deposit(amount);
    }

    // Method for checking balance
    public void checkBalance() {
        currentUser.checkBalance();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a user
        User user = new User("123456", "7890", 1000.0);

        // Create an ATM
        ATM atm = new ATM(user);

        // Prompt user for user ID and PIN
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM. Please enter your user ID:");
        String userID = scanner.nextLine();
        System.out.println("Please enter your PIN:");
        String userPIN = scanner.nextLine();

        // Authenticate user
        if (atm.authenticateUser(userID, userPIN)) {
            System.out.println("Authentication successful. Welcome, " + userID + "!");
            // Display menu and handle user input
            // For simplicity, let's assume user enters 1 for deposit, 2 for withdrawal, and 3 for balance check
            System.out.println("Please choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Authentication failed. Incorrect user ID or PIN.");
        }
    }
}

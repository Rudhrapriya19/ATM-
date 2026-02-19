import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        // Initialize variables
        double balance = 5000.00; // Starting balance
        int pin = 1234;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to the Java Bank ATM ---");
        
        // Simple PIN verification
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Successfully deposited.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal > balance) {
                        System.out.println("Error: Insufficient funds.");
                    } else if (withdrawal <= 0) {
                        System.out.println("Invalid amount.");
                    } else {
                        balance -= withdrawal;
                        System.out.println("Please take your cash.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

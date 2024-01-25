import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first digit(s)
        System.out.println("Enter the first digit(s):");

        // Get the first number from the user (which can be one or two digits)
        int firstDigit = getNumber(scanner);

        // Prompt the user to enter the operation (+, -, *, /)
        System.out.println("Enter the operation (+, -, *, /):");

        // Get the operator from the user
        char operator = getOperator(scanner);

        // Prompt the user to enter the second digit(s)
        System.out.println("Enter the second digit(s):");

        // Get the second number from the user (which can be one or two digits)
        int secondDigit = getNumber(scanner);

        // Perform the calculation based on the user's input
        int result = calculate(firstDigit, operator, secondDigit);

        // Display the result of the calculation
        System.out.println("Result: " + result);

        // Close the Scanner to prevent resource leaks
        scanner.close();
    }

    // Method to get a number (one or two digits) from the user
    private static int getNumber(Scanner scanner) {
        while (true) {
            // Read user input as a string
            String input = scanner.nextLine();
            try {
                // Attempt to convert the input string to an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Handle the exception if the input is not a valid number
                System.out.println("Invalid input. Enter a valid number. Try again:");
            }
        }
    }

    // Method to get the operator (+, -, *, /) from the user
    private static char getOperator(Scanner scanner) {
        while (true) {
            // Read user input as a string
            String input = scanner.nextLine();
            // Check if the input is a valid operator
            if (input.length() == 1 && (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/')) {
                return input.charAt(0);
            } else {
                // Prompt the user to enter a valid operator
                System.out.println("Invalid operator. Enter +, -, *, or /. Try again:");
            }
        }
    }

    // Method to perform the calculation based on the operator
    private static int calculate(int firstDigit, char operator, int secondDigit) {
        // Perform the calculation based on the specified operator
        switch (operator) {
            case '+':
                return firstDigit + secondDigit;
            case '-':
                return firstDigit - secondDigit;
            case '*':
                return firstDigit * secondDigit;
            case '/':
                // Check for division by zero
                if (secondDigit != 0) {
                    return firstDigit / secondDigit;
                } else {
                    // Display an error message and exit if attempting to divide by zero
                    System.out.println("Cannot divide by zero. Exiting...");
                    System.exit(1);
                }
            default:
                // Throw an exception for an invalid operator
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

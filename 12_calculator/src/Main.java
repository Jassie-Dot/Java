import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // SIMPLE CALCULATOR
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Welcome to the Simple Calculator, " + name + "!");
        System.out.println();

        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter the operation (+, -, *, /): ");
        String operation = scanner.next(); // use next() not nextLine()

        System.out.println();

        switch (operation) {
            case "+":
                System.out.println("The addition of " + number1 + " and " + number2 + " is " + (number1 + number2));
                break;
            case "-":
                System.out.println("The subtraction of " + number1 + " and " + number2 + " is " + (number1 - number2));
                break;
            case "*":
                System.out.println("The multiplication of " + number1 + " and " + number2 + " is " + (number1 * number2));
                break;
            case "/":
                if (number2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    double result = (double) number1 / number2;
                    System.out.println("The division of " + number1 + " and " + number2 + " is " + result);
                }
                break;
            default:
                System.out.println("INVALID OPERATION!");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Arthematic operation.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int x = scanner.nextInt();
        System.out.print("Enter the number 2: ");
        int y = scanner.nextInt();
        int z = x + y;
        int a = x - y;
        int b = x * y;
        int c = x / y;
        System.out.print("\n");
        System.out.println("Number 1: " + x);
        System.out.println("Number 2: " + y);
        System.out.print("\n");
        System.out.println("Performing operations...");
        System.out.print("\n");

        System.out.println("Addition: " + z);
        System.out.println("Subraction: " + a);
        System.out.println("Multiplication: " + b);
        System.out.println("Division: " + c);

        scanner.close();
    }
}

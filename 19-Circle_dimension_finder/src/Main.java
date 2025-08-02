import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // CIRCLE DIMENSION FINDER...
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        double radius;
        double PI = Math.PI;
        System.out.println();
        System.out.println(name + " Welcome to the circle dimension finder (AREA/CIRCUMFERENCE)..");
        System.out.println();
        System.out.println("Do you want to continue? (Yes/No): ");
        String operation;
        operation = scanner.nextLine();
        if (operation.equals("Yes") || operation.equals("yes")) {
            System.out.println();
            System.out.println("PROCESSING...");
            System.out.println();
            System.out.println("What do you want to find? (Area/Circumference): ");
            String op = scanner.nextLine();
            if (op.equals("Area") || op.equals("area")) {
                System.out.println("OPERATION AREA...");
                System.out.print("Enter the value of Radius: ");
                radius = scanner.nextDouble();
                double area = PI * Math.pow(radius, 2);
                System.out.println();

                System.out.println("Radius: " + radius+"cm.");
                System.out.println("PROCESSING...");
                System.out.println();
                System.out.println("The AREA of circle is: " + area+"cm^2.");
            } else if(op.equals("Circumference")||op.equals("circumference")) {
                System.out.println("OPERATION CIRCUMFERENCE...");
                System.out.print("Enter the value of Radius: ");
                radius = scanner.nextDouble();
                double circumference = 2 * PI * Math.pow(radius, 2);
                System.out.println();
                System.out.print("Enter the value of Radius: ");
                System.out.println("Radius: " + radius+"cm.");
                System.out.println("PROCESSING...");
                System.out.println();
                System.out.println("The CIRCUMFERENCE of circle is: " + circumference+"cm.");
            } else{
                System.out.println("INVALID OPERATION...");
            }
            System.out.println();
            System.out.println("Thanks for using our program, " + name);
        } else {
            System.out.println();
            System.out.println("PROCESSING...");
            System.out.println("QUITTING...");
        }
        scanner.close();
    }
}
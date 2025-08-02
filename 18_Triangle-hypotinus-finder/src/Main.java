import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TRIANGLE HYPOTENUSE FINDER...
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Welcome " + name + " To the Triangle hypotenuse finder...");
        System.out.println();
        int base, perpendicular;
        System.out.print("Enter the value of BASE in cm: ");
        base = scanner.nextInt();
        System.out.print("Enter the value of PERPENDICULAR in cm: ");
        perpendicular = scanner.nextInt();
        System.out.println();
        System.out.println("PROCESSING....");
        System.out.println();
        System.out.println("Base: " + base + "cm.");
        System.out.println("Perpendicular: " + perpendicular + "cm.");
        System.out.println();
        int hypotenuse = (int) Math.sqrt((Math.pow(base, 2)) + (Math.pow(perpendicular, 2)));
        System.out.println("The hypotenuse of the triangle with base: " + base + "cm." + " and perpendicular: " + perpendicular + "cm.");
        System.out.println();
        System.out.println("Hypotenuse: " + hypotenuse + "cm.");

        scanner.close();
    }
}
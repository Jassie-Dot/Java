import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent=scanner.nextBoolean();

        scanner.close();

        // GROUP 1
        if(name.isEmpty()){ // Checks if name entered is empty
            System.out.println("You didn't entered your name!");
        }
        else{
            System.out.println("Hello "+name+"!")   ;
        }

        // GROUP 2
        if (age >= 18) {
            System.out.println("You are a adult man, " + name + ".");
        } else if (age < 18) {
            System.out.println("You are under age, " + name + ".");
        } else if (age == 0) {
            System.out.println("You are not born't yet, " + name + ".");
        } else if (age >= 60) {
            System.out.println("You are a seniour citizen, " + name + ".");
        }

        // GROUP 3
        if(isStudent){
            System.out.println("You are a student!");
        }
        else{
            System.out.println("You are not a student!");
        }
    }
}
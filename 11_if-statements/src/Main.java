import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // if statements

        Scanner scanner = new Scanner(System.in);

        String name;
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("\n");
        int age;
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        System.out.print("\n");
        scanner.close();
        System.out.println("Welcome " + name + ", you are " + age + " years old.");
        if (age >= 18) {
            System.out.println("You are a adult, " + name);
        } else if (age >= 70) {
            System.out.println("You are old age..");
        } else if (age == 0) {
            System.out.println("You are not born yet...." + name);
        } else {
            System.out.println("You are under age");
        }
    }
}
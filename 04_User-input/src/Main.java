import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name= scanner.nextLine();

        System.out.println("Welcome, "+name);

        System.out.print("Enter your age: ");
        int age=scanner.nextInt();

        System.out.println("Your name is "+name+" and you are "+age+" years old.");

        System.out.print("Enter the GPA you scored in the college: ");
        double gpa=scanner.nextDouble();

        System.out.println(name+ " You have scored "+gpa+" in your college.");
        scanner.close();
    }
}
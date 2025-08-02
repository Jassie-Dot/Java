import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter your name: \n");
        String name=scanner.nextLine();

        System.out.println("Welcome to the number addition program, "+name+"....");
        System.out.println("Enter the two numbers...\n");
        System.out.print("Number 1: ");
        double a=scanner.nextDouble();
        System.out.print("Number 2: \n");
        double b=scanner.nextDouble();

        double add=a+b;
        System.out.println("The addition of "+a+" and "+b+" is: "+add);
        scanner.close();
    }
}
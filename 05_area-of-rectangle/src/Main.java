// Calculate area of rectangle

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name= scanner.nextLine();

        System.out.println("Welcome to the area finder, "+name+".\n");

        System.out.print("Enter the length of rectangle in centimeters: ");
        int length=scanner.nextInt();

        System.out.print("Enter the breadth of rectangle in centimeters: \n");
        int breadth=scanner.nextInt();

        double area= length*breadth;

        System.out.println("Length: "+length+"cm.");
        System.out.println("Breadth: "+breadth+"cm.");
        System.out.println(name+ ", The area of rectangle is: "+area+"cm^2.");
    }
}
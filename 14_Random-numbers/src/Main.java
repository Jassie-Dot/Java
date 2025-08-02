import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        // RANDOM NUMBER
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();

        System.out.print("Enter your name: ");
        String name=scanner.nextLine();
        System.out.println();
        System.out.println("Welcome "+name);

        String operation;
        System.out.print("Do you want to continue? (Yes/No): ");
        operation=scanner.nextLine();

        if(operation.equals("yes") || operation.equals("Yes")){
            System.out.print("OK SIR...");
            System.out.println();

            int number;
            int origin,bound;
            System.out.print("Enter the value you want to origin: ");
            origin=scanner.nextInt();
            System.out.print("Enter the value you want to bound: ");
            bound=scanner.nextInt();
            System.out.println();
            System.out.println("ORIGIN: "+origin);
            System.out.println("BOUND: "+bound);
            System.out.println();
            System.out.println("PROCESSING DATA....");
            System.out.println();
            number= random.nextInt(origin,bound);
            System.out.println("RANDOM NUMBER: "+number);
        }
        else{
            System.out.println("EXITING...");
        }
    }
}
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // HEADS-TAILS program
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name=scanner.nextLine();
        System.out.print("Welcome to the tossing program, "+name);
        System.out.print("Do you want to continue? (YEs/No): ");
        String operation=scanner.nextLine();
        System.out.println();
        System.out.println("PROCESSING...");
        System.out.println();
        if(operation.equals("Yes")||operation.equals("yes")) {

            boolean isHeads;
            isHeads = random.nextBoolean();

            if (isHeads) {
                System.out.println("HEADS");
            } else {
                System.out.println("TAILS");
            }
        }   else{
            System.out.println("QUITTING...");
        }
        scanner.close();
    }
}
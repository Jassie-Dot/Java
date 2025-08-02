public class Main{
    public static void main(String[] args){

        /*
        variable = a reusable container for a value
                   a variable behaves as if it was the value it contains

         primitive:- simpel value stored directoly in the memory(stack)
         reference = memory address (stack) that points to the (heap)

         primitive vs reference
         ---------    ---------
         int           string
         double         array
         char           object
         boolean
        */

        int age=18; // declaration and initialization
        int birth_age=20;
        int year=2006;
        int quantity=1;
        System.out.println("The age is "+ age+" and the year is "+year);
        System.out.println("The birth date is "+birth_age);
        System.out.println("The quantity is "+quantity);

        double height=5.11;
        System.out.println("Your age is "+ height);

        char op='J';
        System.out.println("The value of char is "+ op);

        boolean condition=true;
        System.out.println("The bool value is "+ condition);
    }
}
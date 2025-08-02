public class Main {
    public static void main(String[] args) {

        // printf() = is a method used to format output.

        // %[flags][width][.precision][specifier-character]

        String name="Spongebob";
        char firstLetter='S';
        int age=30;
        double height=60.5;
        boolean isEmployed=true;

        System.out.printf("Hello %s\n",name); // %s for strings
        System.out.printf("Your name starts with a %c\n",firstLetter); // %c for char.
        System.out.printf("You are %d years old.\n",age); // %d for integers.
        System.out.printf("You are %f inches tall\n",height); // %f for doubles.
        System.out.printf("Employes: %b\n",isEmployed);

        // Inserting three variables in same line.
        System.out.printf("Hello %s, you are %d years old and you are %f inches tall.",name,age,height); // Three variables in same line.   
    }
}
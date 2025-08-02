/*
    + = output a plus.
    , = comma grouping separator.
    ( = negative numbers are enclosed in ().
    space = display a minus if negative, space if positive.
*/
public class Main {
    public static void main(String[] args) {
        double price1 = 9.99;
        double price2 = 100.15;
        double price3 = -54.01;

        System.out.printf("%f.2\n", price1); // %f.2 is setting precision in next 2 digits.
        System.out.printf("%f.2\n", price2); // %f.2 is setting precision in next 2 digits.
        System.out.printf("%f.2\n", price3); // %f.2 is setting precision in next 2 digits.

    }
}
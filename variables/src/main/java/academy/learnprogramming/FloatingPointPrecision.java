package academy.learnprogramming;

public class FloatingPointPrecision {

    public static void main(String[] args) {
        int myInt = 5 / 3;
        float myFloat = 5 / 3f;
        double myDouble = 5 / 3.00;

        System.out.println(myInt);
        System.out.println(myFloat);
        System.out.println(myDouble);

        int pounds = 100;
        double kilograms = pounds * 0.45359237;
        System.out.println(kilograms);

        double pi = 22 / 7d;
        System.out.println(pi);
    }
}

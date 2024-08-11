package academy.learnprogramming;

public class LastDigitChecker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (isValid(num1) && isValid(num2) && isValid(num3)) {
            int d1 = num1 % 10;
            int d2 = num2 % 10;
            int d3 = num3 % 10;

            return d1 == d2 || d2 == d3 || d1 == d3;
        } else {
            return false;
        }
    }

    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}

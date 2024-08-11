package academy.learnprogramming;

public class MethodOVerloading {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(0, 1));
        System.out.println(sum(1, 2));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(1, 2, 3, 4));
    }

    public static double calcFeetAndInchesToCentimeters(int feets, int inches) {
        if (feets >= 0 && inches >= 0 && inches <= 12) {
            return (feets * 12 * 2.54) + (inches * 2.54);
        } else {
            return -1;
        }
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches >= 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static int sum(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}

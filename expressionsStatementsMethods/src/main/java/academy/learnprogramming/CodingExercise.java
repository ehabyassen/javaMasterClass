package academy.learnprogramming;

public class CodingExercise {

    public static void main(String[] args) {
        System.out.println(hasTeen(999, 99, 19999));
        System.out.println(a(-3));
    }

    public static double a(double a) {
        if (a < 0) {
            return -1;
        }
        return 0;
    }

    public static boolean hasTeen(int n1, int n2, int n3) {
        return isTeen(n1) || isTeen(n2) || isTeen(n3);
    }

    public static boolean isTeen(int n) {
        return (n >= 13 && n <= 19);
    }
}

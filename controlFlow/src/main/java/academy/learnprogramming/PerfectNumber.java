package academy.learnprogramming;

public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
    }

    public static boolean isPerfectNumber(int num) {
        if (num < 1) {
            return false;
        } else {
            int sum = 0;
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            return sum == num;
        }
    }
}

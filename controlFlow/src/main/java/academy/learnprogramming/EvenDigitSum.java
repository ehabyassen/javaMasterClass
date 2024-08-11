package academy.learnprogramming;

public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
    }

    public static int getEvenDigitSum(int num) {
        if (num < 0) {
            return -1;
        }

        int sum = 0;
        int cur;
        while (num > 0) {
            cur = num % 10;
            sum += cur % 2 == 0? cur : 0;
            num /= 10;
        }
        return sum;
    }
}

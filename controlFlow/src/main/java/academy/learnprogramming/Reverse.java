package academy.learnprogramming;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(2521));
    }

    public static int sumFirstAndLastDigit(int num) {
        if (num < 0) {
            return -1;
        }

        if (num / 10 == 0) {
            return num * 2;
        }

        int firstD = num % 10;
        num /= 10;
        while (num > 0) {
            if (num / 10 == 0) {
                break;
            }
            num /= 10;
        }
        return firstD + num;
    }
}

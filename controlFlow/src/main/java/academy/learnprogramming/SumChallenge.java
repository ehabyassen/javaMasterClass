package academy.learnprogramming;

public class SumChallenge {

    public static void main(String[] args) {
        int sum = 0;
        int c = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 15 == 0) {
                System.out.println("i: " + i);
                sum += i;
                c++;
            }
            if (c == 5) {
                break;
            }
        }
        System.out.println("Sum: " + sum);
    }
}

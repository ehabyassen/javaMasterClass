package academy.learnprogramming;

public class OperatorsChallenge {

    public static void main(String[] args) {
        double v1 = 20.0;
        double v2 = 80.0;
        double res = (v1 + v2) * 100.0;
        boolean noRem = res % 40.00 == 0;

        System.out.println(noRem);
    }
}

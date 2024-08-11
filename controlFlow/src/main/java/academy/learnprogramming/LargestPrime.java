package academy.learnprogramming;

public class LargestPrime {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(12));
    }

    public static int getLargestPrime(int num) {
        if (num < 2) {
            return -1;
        } else {
            boolean isPrime = true;
            for (int i = 1; i < num; i++) {
                if (num % i == 0 && i != 1 && i != 2) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                return num;
            } else {
                int prime = -1;
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        if (i == 2) {
                            prime = 2;
                        } else {
                            boolean isP = true;
                            for (int j = 1; j < i; j++) {
                                if (i % j == 0 && j != 1) {
                                    isP = false;
                                    break;
                                }
                            }
                            if (isP) {
                                prime = i;
                            }
                        }
                    }
                }
                return prime;
            }
        }
    }
}

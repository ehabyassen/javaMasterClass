package academy.learnprogramming;

import java.util.Scanner;

public class MinMax {

    public static void main(String[] args) {
        int min = 0;
        int max = 0;
        int val;
        boolean firstIteration = true;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter number: ");
            if (sc.hasNextInt()) {
                val = sc.nextInt();
                if (firstIteration) {
                    min = val;
                    max = val;
                    firstIteration = false;
                } else {
                    min = Math.min(val, min);
                    max = Math.max(val, max);
                }
            } else {
                break;
            }
        }
        System.out.println("Min: " + min + " Max: " + max);
        sc.close();
    }
}

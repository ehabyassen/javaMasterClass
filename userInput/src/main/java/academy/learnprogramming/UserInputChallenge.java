package academy.learnprogramming;

import java.util.Scanner;

public class UserInputChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        int sum = 0;
        while (counter <= 10) {
            System.out.print("Enter number #" + counter + ": ");
            if (sc.hasNextInt()) {
                sum += sc.nextInt();
                counter++;
            } else {
                sc.next();
                System.out.println("Invalid Number");
            }
        }
        System.out.println("Sum: " + sum);
        sc.close();
    }
}

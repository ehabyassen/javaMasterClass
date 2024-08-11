package academy.learnprogramming;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
        System.out.print("X: ");
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();

        switch (x) {
            case "January":
                System.out.println("1");
                break;
            case "February":
                System.out.println("2");
                break;
            default:
                System.out.println("X");
                break;
        }
    }
}

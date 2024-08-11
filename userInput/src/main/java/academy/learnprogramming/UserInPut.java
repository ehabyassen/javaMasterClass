package academy.learnprogramming;

import java.util.Scanner;

public class UserInPut {

    public static void main(String[] args) {
        System.out.print("Enter your year of birth: ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        while (year < 1900) {
            System.out.println("Year of birth range is 1900 - 2000.");
            System.out.print("Enter your year of birth: ");
            year = sc.nextInt();
        }
        System.out.println("Your year of birth: " + year);
    }
}

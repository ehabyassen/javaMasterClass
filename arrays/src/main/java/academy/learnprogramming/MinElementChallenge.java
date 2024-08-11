package academy.learnprogramming;

import java.util.Scanner;

public class MinElementChallenge {

    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int[] ints = readIntegers(5);
        int min = findMin(ints);
        System.out.println("Min:" + min);
    }

    private static int[] readIntegers(int count) {
        System.out.println("enter " + count + " integers:");
        int[] intArray = new int[count];
        for (int i = 0; i < count; i++) {
            intArray[i] = SC.nextInt();
        }
        return intArray;
    }

    private static int findMin(int[] intArray) {
        int min = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            min = Math.min(min, intArray[i]);
        }
        return min;
    }
}

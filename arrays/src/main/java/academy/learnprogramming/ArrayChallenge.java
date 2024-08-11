package academy.learnprogramming;

import java.util.Scanner;

public class ArrayChallenge {

    public static void main(String[] args) {
        int[] numbers = getIntegers();
        printArray(numbers);
        int[] sortedNumbers = sortIntegers(numbers);
        printArray(sortedNumbers);
    }

    public static int[] getIntegers() {
        System.out.println("Enter the number of integers to sort: ");
        Scanner sc = new Scanner(System.in);
        int numberOfIntegers = sc.nextInt();
        int[] integers = new int[numberOfIntegers];
        System.out.println("Enter " + numberOfIntegers + " integers:");
        for (int i = 0; i < numberOfIntegers; i++) {
            integers[i] = sc.nextInt();
        }
        return integers;
    }

    public static void printArray(int[] integers) {
        System.out.println("-".repeat(30));
        for (int integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println("-".repeat(30));
    }

    public static int[] sortIntegers(int[] nums) {
        int swap;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    swap = nums[j];
                    nums[j] = nums[i];
                    nums[i] = swap;
                }
            }
        }
        return nums;
    }
}

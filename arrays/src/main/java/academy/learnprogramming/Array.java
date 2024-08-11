package academy.learnprogramming;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        printArgs(args);

        System.out.println("-".repeat(30));



        int[] nums = {1, 2, 3};
        int[] b = new int[4];
        b[2] = 3;

        int[] myIntArray = new int[5];
        printArray(myIntArray);
        modifyArray(myIntArray);
        printArray(myIntArray);

        String[] names = new String[5];
        names[0] = "Ehab";
        System.out.println(Arrays.toString(names));

        System.out.println("-".repeat(30));

        printArgs("A", "B", "C");
    }

    private static void printArgs(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void printArray(int[] b) {
        for (int j : b) {
            System.out.print(j);
        }
        System.out.println();
    }

    private static void modifyArray(int[] array) {
        array = new int[] {1, 2, 3, 4};
        printArray(array);
    }
}

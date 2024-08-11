package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayChallenge {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(ints));
        reverseArray(ints);
        System.out.println(Arrays.toString(ints));

        ArrayList objects = new ArrayList<>();

    }

    private static void reverseArray(int[] ints) {
        int swap;
        for(int i = 0; i < ints.length / 2; i++) {
            swap = ints[i];
            ints[i] = ints[ints.length - 1 - i];
            ints[ints.length - 1 - i] = swap;
        }
    }
}

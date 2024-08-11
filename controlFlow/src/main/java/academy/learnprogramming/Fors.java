package academy.learnprogramming;

public class Fors {

    public static void main(String[] args) {

        for (int x = 0, y = 0; x < 4 && y < 3; x++, y++) {
            System.out.println("a");
        }

        int[] nums = {1, 2, 3};
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

package academy.learnprogramming;

public class Whiles {

    public static void main(String[] args) {
        int start = 4;
        int end = 20;
        int total = 0;
        int c = 0;

        while (end >= start) {
            if (isEvenNumber(start)) {
                System.out.println(start + " is even number.");
                total++;
                c++;
            }
            start++;
            if (c == 5) {
                break;
            }
        }

        System.out.println("Total: " + total);
    }

    private static boolean isEvenNumber(int n) {
        return n % 2 == 0;
    }
}

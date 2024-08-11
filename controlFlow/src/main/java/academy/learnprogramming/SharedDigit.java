package academy.learnprogramming;

public class SharedDigit {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
    }

    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }

        int cur1;
        while (num1 > 0) {
            cur1 = num1 % 10;
            num1 /= 10;

            int cur2;
            int copy2 = num2;
            while (copy2 > 0) {
                cur2 = copy2 % 10;
                copy2 /= 10;

                if (cur1 == cur2) {
                    return true;
                }
            }
        }
        return false;
    }
}

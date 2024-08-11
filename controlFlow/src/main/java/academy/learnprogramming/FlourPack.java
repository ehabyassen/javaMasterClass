package academy.learnprogramming;

public class FlourPack {

    public static void main(String[] args) {
        System.out.println(canPack(2, 1, 5));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int sum = (bigCount * 5) + smallCount;
        if (sum == goal) {
            return true;
        } else if  (sum < goal) {
            return false;
        } else {
            int l = 0;
            for (int i = 1; i <= bigCount; i++) {
                if (i * 5 > goal)
                {
                    break;
                }
                l++;
            }
            int rem = goal - (l * 5);
            return rem <= smallCount && rem >= 0;
        }
    }
}

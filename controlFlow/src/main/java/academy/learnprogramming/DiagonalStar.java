package academy.learnprogramming;

public class DiagonalStar {

    public static void main(String[] args) {
        printSquareStar(8);
    }


    public static void printSquareStar(int num) {
        if (num < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    boolean firstOrLastRow = i == 1 || i == num;
                    boolean firstOrLastColumn = j == 1 || j == num;
                    boolean rowEqualsColumn = i == j;
                    boolean special = j == (num - i + 1);
                    if (firstOrLastRow || firstOrLastColumn || rowEqualsColumn || special) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }
}

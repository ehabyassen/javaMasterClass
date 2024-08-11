package academy.learnprogramming;

public class Statements {

    public static void main(String[] args) {
        int myVar = 50;

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Final score: " + finalScore);
            score = 10000;
            levelCompleted = 8;
            bonus = 200;
            finalScore = score + (levelCompleted * bonus);
            System.out.println("Final score: " + finalScore);
        }

        String name = "Ehab";
        System.out.println(name);
        changeName(name);
        System.out.println(name);
    }

    public static void changeName(String name) {
        name = "Aya";
    }
}

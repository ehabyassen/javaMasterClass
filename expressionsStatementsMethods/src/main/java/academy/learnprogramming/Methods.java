package academy.learnprogramming;

public class Methods {

    public static void main(String[] args) {
        displayHighScorePosition("Eslam", calculateHighScorePosition(1500));
        displayHighScorePosition("Aya", calculateHighScorePosition(900));
        displayHighScorePosition("Ehab", calculateHighScorePosition(400));
        displayHighScorePosition("Roi", calculateHighScorePosition(50));
    }

    static void displayHighScorePosition(String playerName, int position) {
        System.out.println("Player: " + playerName + " is in position: " + position);
    }

    static int calculateHighScorePosition(int score) {
        int position = 4;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }
        return position;
    }
}

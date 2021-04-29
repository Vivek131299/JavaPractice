public class Methods {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        int highScorePosition;

        highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Percy", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Gilbert", highScorePosition);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }

        return -1; // Alternatively, we can put 'return -1;' in else part after if part.
    }

    public static void displayHighScorePosition(String name, int highScorePosition) {
        System.out.println(name + " managed to get into position " + highScorePosition + " on the high score table");
    }

    public static int calculateHighScorePosition(int score) {
        /*
         * if (score >= 1000) { return 1; } else if (score >= 500) { return 2; } else if
         * (score >= 100) { return 3; }
         * 
         * return 4;
         */

        // Alternatively, we can write above commented code as below to eliminate
        // multiple return statements.

        int position = 4; // Assuming position 4 will be returned.

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

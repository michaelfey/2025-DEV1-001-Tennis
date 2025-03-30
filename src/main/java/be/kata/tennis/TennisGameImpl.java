package be.kata.tennis;

public class TennisGameImpl implements TennisGame {
    private static final String SCORE_BOARD = "%s - %s";
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;

    TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (player1Score >= 3 && player2Score >= 3 && player1Score > player2Score) {
            return "Advantage " + player1Name;
        }
        String player1Score = mapPlayerScoreToText(this.player1Score);
        String player2Score = mapPlayerScoreToText(this.player2Score);
        return String.format(SCORE_BOARD, player1Score, player2Score);
    }


    @Override
    public void scorePoint(String scoringPlayerName) {
        if (scoringPlayerName.equals(player1Name)) {
            player1Score++;
        } else if (scoringPlayerName.equals(player2Name)) {
            player2Score++;
        }
    }

    private String mapPlayerScoreToText(int playerScore) {
        String[] scoreText = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreText[playerScore];
    }

    private boolean isDeuce() {
        return player1Score == player2Score && player1Score == 3;
    }
}

package be.kata.tennis;

public class TennisGameImpl implements TennisGame {
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;

    TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player1Name;
    }

    @Override
    public String getScore() {
        String scoreBoard = "%s - %s";
        String player1Score = mapPlayerScoreToText(this.player1Score);
        String player2Score = mapPlayerScoreToText(this.player2Score);
        return String.format(scoreBoard, player1Score, player2Score);
    }

    @Override
    public void scorePoint(String scoringPlayerName) {
        if (scoringPlayerName.equals(player1Name)) {
            player1Score++;
        } else if (scoringPlayerName.equals(player2Name)) {
            player2Score++;
        }
    }

    String mapPlayerScoreToText(int playerScore) {
        String[] scoreText = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreText[playerScore];
    }
}

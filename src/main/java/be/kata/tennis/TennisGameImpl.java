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
        String formattedPlayer1Score = "";
        String formattedPlayer2Score = "";
        if(player1Score == 0) {
            formattedPlayer1Score = "Love";
        }
        if(player2Score == 0) {
            formattedPlayer2Score = "Love";
        }
        if(player1Score == 1) {
            formattedPlayer1Score = "Fifteen";
        }
        if(player2Score == 1) {
            formattedPlayer2Score = "Fifteen";
        }
        return String.format(scoreBoard, formattedPlayer1Score, formattedPlayer2Score);
    }

    @Override
    public void scorePoint(String scoringPlayerName) {
        if (scoringPlayerName.equals(player1Name)) {
            player1Score++;
        }
        else if (scoringPlayerName.equals(player2Name)) {
            player2Score++;
        }
    }
}

package be.kata.tennis;

import org.apache.commons.lang3.StringUtils;

public class TennisGameImpl implements TennisGame {
    private static final String SCORE_BOARD = "%s - %s";
    private Player player1;
    private Player player2;


    TennisGameImpl(String player1Name, String player2Name) {
        if (StringUtils.isEmpty(player1Name) || StringUtils.isEmpty(player2Name)) {
            throw new IllegalArgumentException("Both names of player1 and player2 should be provided");
        }
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    @Override
    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (hasAdvantage()) {
            return "Advantage " + leadingPlayer();
        }
        if (hasWinner()) {
            return "Win for " + leadingPlayer();
        }
        String player1Score = mapPlayerScoreToText(this.player1.getScore());
        String player2Score = mapPlayerScoreToText(this.player2.getScore());
        return String.format(SCORE_BOARD, player1Score, player2Score);
    }

    private boolean hasWinner() {
        return Math.max(player1.getScore(), player2.getScore()) >= 4 && Math.abs(player1.getScore() - player2.getScore()) >= 2;
    }

    private boolean hasAdvantage() {
        return Math.max(player1.getScore(), player2.getScore()) >= 4 && Math.abs(player1.getScore() - player2.getScore()) == 1;
    }

    private String leadingPlayer() {
        return this.player1.isLeading(player2) ? player1.getName() : player2.getName();
    }


    @Override
    public void scorePoint(String scoringPlayerName) {
        if (scoringPlayerName.equals(player1.getName())) {
            player1.addPoint();
        } else if (scoringPlayerName.equals(player2.getName())) {
            player2.addPoint();
        } else {
            throw new IllegalArgumentException(String.format("Player with name %s is currently not playing", scoringPlayerName));
        }

    }

    private String mapPlayerScoreToText(int playerScore) {
        String[] scoreText = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreText[playerScore];
    }

    private boolean isDeuce() {
        return player1.getScore() == player2.getScore() && player1.getScore() >= 3;
    }
}

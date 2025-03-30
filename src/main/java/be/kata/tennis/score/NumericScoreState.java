package be.kata.tennis.score;

import be.kata.tennis.Players;

public class NumericScoreState implements ScoreState {
    @Override
    public boolean test(Players players) {
        return players.getPlayer1Score() <= 3 && players.getPlayer2Score() <= 3;
    }

    @Override
    public String getScore(Players players) {
        return String.format("%s - %s", mapPlayerScoreToText(players.getPlayer1Score()), mapPlayerScoreToText(players.getPlayer2Score()));
    }

    private String mapPlayerScoreToText(int playerScore) {
        String[] scoreText = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreText[playerScore];
    }
}

package be.kata.tennis.score;

import be.kata.tennis.Players;

public class DeuceScoreState implements ScoreState {
    @Override
    public boolean test(Players players) {
        return players.getPlayer1Score() == players.getPlayer2Score() && players.getPlayer1Score() >= 3;
    }

    @Override
    public String getScore(Players players) {
        return "Deuce";
    }
}

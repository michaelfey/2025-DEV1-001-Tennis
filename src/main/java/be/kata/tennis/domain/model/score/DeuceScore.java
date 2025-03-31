package be.kata.tennis.domain.model.score;

import be.kata.tennis.domain.model.Players;

public class DeuceScore implements Score {
    @Override
    public boolean test(Players players) {
        return players.getPlayer1Score() == players.getPlayer2Score() && players.getPlayer1Score() >= 3;
    }

    @Override
    public String getValue(Players players) {
        return "Deuce";
    }
}

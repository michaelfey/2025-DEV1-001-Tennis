package be.kata.tennis.score;

import be.kata.tennis.Players;

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

package be.kata.tennis.domain.score;

import be.kata.tennis.domain.Players;

public class WinningScore implements Score {
    @Override
    public boolean test(Players players) {
        return players.getMaxScoreOfPlayers() >= 4 && players.getScoreDifference() >= 2;
    }

    @Override
    public String getValue(Players players) {
        return "Win for " + players.getLeadingPlayerName();
    }
}

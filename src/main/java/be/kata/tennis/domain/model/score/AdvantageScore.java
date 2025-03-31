package be.kata.tennis.domain.model.score;

import be.kata.tennis.domain.model.Players;

public class AdvantageScore implements Score {
    @Override
    public boolean test(Players players) {
        return players.getMaxScoreOfPlayers() >= 4 && players.getScoreDifference() == 1;
    }

    @Override
    public String getValue(Players players) {
        return "Advantage "+players.getLeadingPlayerName();
    }
}

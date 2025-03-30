package be.kata.tennis.score;

import be.kata.tennis.Players;

public class AdvantageScoreState implements ScoreState {
    @Override
    public boolean test(Players players) {
        return players.getMaxScoreOfPlayers() >= 4 && players.getScoreDifference() == 1;
    }

    @Override
    public String getScore(Players players) {
        return "Advantage "+players.getLeadingPlayerName();
    }
}

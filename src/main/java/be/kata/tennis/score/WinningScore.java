package be.kata.tennis.score;

import be.kata.tennis.Players;

public class WinningScore implements ScoreState {
    @Override
    public boolean test(Players players) {
        return players.getMaxScoreOfPlayers() >= 4 && players.getScoreDifference() >= 2;
    }

    @Override
    public String getScore(Players players) {
        return "Win for " + players.getLeadingPlayerName();
    }
}

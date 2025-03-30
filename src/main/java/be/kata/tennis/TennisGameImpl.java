package be.kata.tennis;

import be.kata.tennis.score.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TennisGameImpl implements TennisGame {
    private final Players players;

    TennisGameImpl(String player1Name, String player2Name) {
        if (StringUtils.isEmpty(player1Name) || StringUtils.isEmpty(player2Name)) {
            throw new IllegalArgumentException("Both names of player1 and player2 should be provided");
        }
        this.players = new Players(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        List<Score> scores = Arrays.asList(new AdvantageScore(), new WinningScore(), new DeuceScore(), new NumericScore());
        Score currentScore = scores.stream()
                .filter(score -> score.test(players))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No score found"));
        return currentScore.getValue(players);
    }

    @Override
    public void scorePoint(String scoringPlayerName) {
        players.scorePoint(scoringPlayerName);
    }
}

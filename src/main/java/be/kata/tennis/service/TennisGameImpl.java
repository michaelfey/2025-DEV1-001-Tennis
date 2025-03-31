package be.kata.tennis.service;

import be.kata.tennis.domain.Players;
import be.kata.tennis.domain.score.AdvantageScore;
import be.kata.tennis.domain.score.DeuceScore;
import be.kata.tennis.domain.score.NumericScore;
import be.kata.tennis.domain.score.Score;
import be.kata.tennis.domain.score.WinningScore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TennisGameImpl implements TennisGame {
    private Players players;

    @Override
    public void startGame(String player1Name, String player2Name) {
        if (StringUtils.isEmpty(player1Name) || StringUtils.isEmpty(player2Name)) {
            throw new IllegalArgumentException("Both names of player1 and player2 should be provided");
        }
        this.players = new Players(player1Name, player2Name);
    }

    @Override
    public String getScore() {
        Score currentScore = getCurrentScore();
        return currentScore.getValue(players);
    }

    private Score getCurrentScore() {
        List<Score> scores = Arrays.asList(new AdvantageScore(), new WinningScore(), new DeuceScore(), new NumericScore());
        Score currentScore = scores.stream()
                .filter(score -> score.test(players))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No score found"));
        return currentScore;
    }

    @Override
    public void scorePoint(String scoringPlayerName) {
        if (players == null) {
            throw new IllegalStateException("Game has not started yet, please start a new game");
        }
        if(getCurrentScore() instanceof WinningScore) {
            throw new IllegalStateException("The game is already finished, please start a new game");
        }
        players.scorePoint(scoringPlayerName);
    }

}

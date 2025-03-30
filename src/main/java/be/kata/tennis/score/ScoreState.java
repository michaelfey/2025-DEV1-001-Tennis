package be.kata.tennis.score;

import be.kata.tennis.Players;

public interface ScoreState {
    boolean test(Players players);
    String getScore(Players players);
}

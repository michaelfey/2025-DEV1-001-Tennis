package be.kata.tennis.score;

import be.kata.tennis.Players;

public interface Score {
    boolean test(Players players);
    String getValue(Players players);
}

package be.kata.tennis.domain.score;

import be.kata.tennis.domain.Players;

public interface Score {
    boolean test(Players players);
    String getValue(Players players);
}

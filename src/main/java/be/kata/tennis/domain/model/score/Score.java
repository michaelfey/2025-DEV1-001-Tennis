package be.kata.tennis.domain.model.score;

import be.kata.tennis.domain.model.Players;

public interface Score {
    boolean test(Players players);
    String getValue(Players players);
}

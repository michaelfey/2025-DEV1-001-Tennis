package be.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    @Test
    void whenGameStarted_thenScoreShouldBeLoveLove() {
        TennisGame tennisGame = new TennisGameImpl("Heisenberg", "Gustavo Fring");
        assertThat(tennisGame.getScore()).isEqualTo("Love - Love");
    }
}

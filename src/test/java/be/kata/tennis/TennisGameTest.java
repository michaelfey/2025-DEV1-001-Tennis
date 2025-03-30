package be.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {


    @Test
    void whenGameStarted_thenScoreShouldBeLoveLove() {
        TennisGame tennisGame = new TennisGameImpl("Heisenberg", "Gustavo Fring");
        assertThat(tennisGame.getScore()).isEqualTo("Love - Love");
    }

    @Test
    void givenScoreIsLoveLove_whenPlayer1Scores_ThenScoreIsFifteenLove() {
        TennisGame tennisGame = new TennisGameImpl("Heisenberg", "Gustavo Fring");
        tennisGame.scorePoint("Heisenberg");
        assertThat(tennisGame.getScore()).isEqualTo("Fifteen - Love");
    }
}

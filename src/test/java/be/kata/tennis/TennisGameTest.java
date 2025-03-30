package be.kata.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    private TennisGame tennisGame;
    private static final String PLAYER_1 = "Heisenberg";
    private static final String PLAYER_2 = "Gustavo Fring";

    @BeforeEach
    void before() {
        this.tennisGame = new TennisGameImpl(PLAYER_1, PLAYER_2);
    }

    @Test
    void whenGameStarted_thenScoreShouldBeLoveLove() {
        simulateTennisGame(0,0);
        assertThat(tennisGame.getScore()).isEqualTo("Love - Love");
    }

    @Test
    void givenScoreIsLoveLove_whenPlayer1Scores_ThenScoreIsFifteenLove() {
        simulateTennisGame(1,0);

        assertThat(tennisGame.getScore()).isEqualTo("Fifteen - Love");
    }

    @Test
    void givenScoreIsFifteenLove_whenPlayer1Scores_ThenScoreIsThirtyLove() {
        simulateTennisGame(2,0);

        assertThat(tennisGame.getScore()).isEqualTo("Thirty - Love");
    }

    private void simulateTennisGame(int player1Points, int player2Points) {
        for (int i = 0; i < player1Points; i++) this.tennisGame.scorePoint(PLAYER_1);
        for (int i = 0; i < player2Points; i++) this.tennisGame.scorePoint(PLAYER_2);
    }
}

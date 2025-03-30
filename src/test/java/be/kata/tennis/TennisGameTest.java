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

    @Test
    void whenPlayer1Scores3Points_ThenScoreIsFortyLove() {
        simulateTennisGame(3,0);

        assertThat(tennisGame.getScore()).isEqualTo("Forty - Love");
    }

    @Test
    void whenPlayer2Scores1Point_ThenScoreIsLoveFifteen() {
        simulateTennisGame(0,1);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Fifteen");
    }

    @Test
    void whenPlayer2Scores2Points_ThenScoreIsLoveThirty() {
        simulateTennisGame(0,2);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Thirty");
    }

    @Test
    void whenPlayer2Scores3Points_ThenScoreIsLoveForty() {
        simulateTennisGame(0,3);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Forty");
    }

    private void simulateTennisGame(int player1Points, int player2Points) {
        for (int i = 0; i < player1Points; i++) this.tennisGame.scorePoint(PLAYER_1);
        for (int i = 0; i < player2Points; i++) this.tennisGame.scorePoint(PLAYER_2);
    }
}

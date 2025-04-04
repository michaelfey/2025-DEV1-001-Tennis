package be.kata.tennis.service;

import be.kata.tennis.domain.port.TennisGame;
import be.kata.tennis.domain.service.TennisGameImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TennisGameTest {

    private TennisGame tennisGame;
    private static final String PLAYER_1 = "Heisenberg";
    private static final String PLAYER_2 = "Gustavo Fring";

    @BeforeEach
    void before() {
        this.tennisGame = new TennisGameImpl();
        this.tennisGame.startGame(PLAYER_1, PLAYER_2);
    }

    @Test
    void givenPlayer1IsNull_whenGameStarts_thenExceptionIsThrown() {
        this.tennisGame = new TennisGameImpl();
        assertThatThrownBy(() -> this.tennisGame.startGame(null, "player 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both names of player1 and player2 should be provided");
    }

    @Test
    void givenPlayer1IsEmpty_whenGameStarts_thenExceptionIsThrown() {
        this.tennisGame = new TennisGameImpl();
        assertThatThrownBy(() -> this.tennisGame.startGame("", "player 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both names of player1 and player2 should be provided");
    }

    @Test
    void givenPlayer2IsNull_whenGameStarts_thenExceptionIsThrown() {
        this.tennisGame = new TennisGameImpl();
        assertThatThrownBy(() -> this.tennisGame.startGame("player1", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both names of player1 and player2 should be provided");
    }

    @Test
    void givenPlayer2IsEmpty_whenGameStarts_thenExceptionIsThrown() {
        this.tennisGame = new TennisGameImpl();
        assertThatThrownBy(() -> this.tennisGame.startGame("player 1", ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both names of player1 and player2 should be provided");
    }

    @Test
    void givenScorePointCalled_whenPlayerNotFound_thenExceptionIsThrown() {
        this.tennisGame = new TennisGameImpl();
        this.tennisGame.startGame(PLAYER_1, PLAYER_2);
        assertThatThrownBy(() -> this.tennisGame.scorePoint("unknown player"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Player with name unknown player is currently not playing");
    }

    @Test
    void whenGameStarted_thenScoreShouldBeLoveLove() {
        simulateTennisGame(0, 0);
        assertThat(tennisGame.getScore()).isEqualTo("Love - Love");
    }

    @Test
    void givenScoreIsLoveLove_whenPlayer1Scores_ThenScoreIsFifteenLove() {
        simulateTennisGame(1, 0);

        assertThat(tennisGame.getScore()).isEqualTo("Fifteen - Love");
    }

    @Test
    void givenScoreIsFifteenLove_whenPlayer1Scores_ThenScoreIsThirtyLove() {
        simulateTennisGame(2, 0);

        assertThat(tennisGame.getScore()).isEqualTo("Thirty - Love");
    }

    @Test
    void whenPlayer1Scores3Points_ThenScoreIsFortyLove() {
        simulateTennisGame(3, 0);

        assertThat(tennisGame.getScore()).isEqualTo("Forty - Love");
    }

    @Test
    void whenPlayer2Scores1Point_ThenScoreIsLoveFifteen() {
        simulateTennisGame(0, 1);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Fifteen");
    }

    @Test
    void whenPlayer2Scores2Points_ThenScoreIsLoveThirty() {
        simulateTennisGame(0, 2);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Thirty");
    }

    @Test
    void whenPlayer2Scores3Points_ThenScoreIsLoveForty() {
        simulateTennisGame(0, 3);

        assertThat(tennisGame.getScore()).isEqualTo("Love - Forty");
    }

    @Test
    void whenBothPlayersReach3points_thenScoreIsDeuce() {
        simulateTennisGame(3, 3);
        assertThat(tennisGame.getScore()).isEqualTo("Deuce");

    }

    @Test
    void givenGameIsDeuce_whenPlayer1Scores_thenPlayer1IsInAdvantage() {
        simulateTennisGame(3, 3);

        tennisGame.scorePoint(PLAYER_1);

        assertThat(tennisGame.getScore()).isEqualTo("Advantage Heisenberg");

    }

    @Test
    void givenGameIsDeuce_whenPlayer2Scores_thenPlayer2IsInAdvantage() {
        simulateTennisGame(3, 3);

        tennisGame.scorePoint(PLAYER_2);

        assertThat(tennisGame.getScore()).isEqualTo("Advantage Gustavo Fring");
    }

    @Test
    void givenPlayer1HasAdvantage_whenPlayer2Scores_thenGameIsDeuce() {
        simulateTennisGame(4, 3);

        tennisGame.scorePoint(PLAYER_2);

        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
    }

    @Test
    void givenPlayer1HasAdvantage_whenPlayer1Scores_thenPlayer1Wins() {
        simulateTennisGame(4, 3);

        tennisGame.scorePoint(PLAYER_1);

        assertThat(tennisGame.getScore()).isEqualTo("Win for Heisenberg");
    }

    @Test
    void givenPlayer2HasAdvantage_whenPlayer1Scores_thenGameIsDeuce() {
        simulateTennisGame(3, 4);

        tennisGame.scorePoint(PLAYER_1);

        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
    }

    @Test
    void givenPlayer2HasAdvantage_whenPlayer2Scores_thenPlayer2Wins() {
        simulateTennisGame(3, 4);

        tennisGame.scorePoint(PLAYER_2);

        assertThat(tennisGame.getScore()).isEqualTo("Win for Gustavo Fring");
    }

    @Test
    void whenPlayer1Scores4PointsWithoutDeuce_thenPlayer1Wins() {
        simulateTennisGame(4, 2);

        assertThat(tennisGame.getScore()).isEqualTo("Win for Heisenberg");
    }

    @Test
    void whenPlayer2Scores4PointsWithoutDeuce_thenPlayer2Wins() {
        simulateTennisGame(1, 4);

        assertThat(tennisGame.getScore()).isEqualTo("Win for Gustavo Fring");
    }

    private void simulateTennisGame(int player1Points, int player2Points) {
        if (player1Points <= player2Points) {
            IntStream.range(0, player1Points).forEach(i -> tennisGame.scorePoint(PLAYER_1));
            IntStream.range(0, player2Points).forEach(i -> tennisGame.scorePoint(PLAYER_2));
        } else {
            IntStream.range(0, player2Points).forEach(i -> tennisGame.scorePoint(PLAYER_2));
            IntStream.range(0, player1Points).forEach(i -> tennisGame.scorePoint(PLAYER_1));
        }

    }
}

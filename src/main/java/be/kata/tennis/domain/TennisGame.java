package be.kata.tennis.domain;

public interface TennisGame {

    String getScore();

    void scorePoint(String scoringPlayerName);

    void startGame(String player1Name, String player2Name);
}

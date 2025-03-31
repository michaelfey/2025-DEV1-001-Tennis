package be.kata.tennis.domain.service;

public interface TennisGame {

    String getScore();

    void scorePoint(String scoringPlayerName);

    void startGame(String player1Name, String player2Name);
}

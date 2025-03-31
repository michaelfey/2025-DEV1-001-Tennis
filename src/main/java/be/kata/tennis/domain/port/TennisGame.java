package be.kata.tennis.domain.port;

public interface TennisGame {

    String getScore();

    void scorePoint(String scoringPlayerName);

    void startGame(String player1Name, String player2Name);
}

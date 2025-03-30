package be.kata.tennis;

public class TennisGameImpl implements TennisGame {
    private String player1Name;
    private String player2Name;
    TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player1Name;
    }
}

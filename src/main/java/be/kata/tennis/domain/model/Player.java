package be.kata.tennis.domain.model;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    public boolean isLeading(Player other) {
        return this.score > other.getScore();
    }
}

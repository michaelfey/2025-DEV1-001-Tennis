package be.kata.tennis;

public class Players {
    private final Player player1;
    private final Player player2;

    public Players(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public int getPlayer1Score() {
        return this.player1.getScore();
    }

    public int getPlayer2Score() {
        return this.player2.getScore();
    }

    public String getLeadingPlayerName() {
        return player1.isLeading(player2) ? player1.getName() : player2.getName();
    }

    public int getMaxScoreOfPlayers() {
        return Math.max(player1.getScore(), player2.getScore());
    }

    public int getScoreDifference() {
        return Math.abs(player1.getScore() - player2.getScore());
    }

    public void scorePoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.addPoint();
        } else if (playerName.equals(player2.getName())) {
            player2.addPoint();
        } else {
            throw new IllegalArgumentException(String.format("Player with name %s is currently not playing", playerName));
        }
    }

}

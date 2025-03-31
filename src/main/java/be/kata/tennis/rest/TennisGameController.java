package be.kata.tennis.rest;

import be.kata.tennis.api.TennisGameApi;
import be.kata.tennis.domain.port.TennisGame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TennisGameController implements TennisGameApi {

    private final TennisGame tennisGame;

    TennisGameController(TennisGame tennisGame) {
        this.tennisGame = tennisGame;
    }

    @Override
    public ResponseEntity<String> _apiV1NewGamePost(String player1, String player2) {
        this.tennisGame.startGame(player1, player2);
        return ResponseEntity.ok(String.format("Tennis game started between %s and %s", player1, player2));
    }

    @Override
    public ResponseEntity<String> _apiV1PointPlayerNamePost(String playerName) {
        this.tennisGame.scorePoint(playerName);
        return ResponseEntity.ok(this.tennisGame.getScore());
    }

    @Override
    public ResponseEntity<String> _apiV1ScoreGet() {
        return ResponseEntity.ok(this.tennisGame.getScore());
    }
}

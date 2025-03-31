package be.kata.tennis.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TennisControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldStartGame() throws Exception {
        mockMvc.perform(post("/api/v1/new-game")
                        .param("player1", "Hannibal")
                        .param("player2", "Clarice")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Tennis game started between Hannibal and Clarice"));
    }

    @Test
    void shouldThrowError_whenGameIsStartedWithEmptyPlayerParams() throws Exception {
        mockMvc.perform(post("/api/tennis/new-game")
                        .param("player1", "")
                        .param("player2", "")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldShowStartGameError_whenTryingToScoreWithoutStartingTheGame() throws Exception {
        mockMvc.perform(post("/api/tennis/point/Clarice"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnLoveLoveAtStart() throws Exception {
        mockMvc.perform(post("/api/tennis/new-game")
                        .param("player1", "Hannibal")
                        .param("player2", "Clarice")
                )
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/tennis/score"))
                .andExpect(status().isOk())
                .andExpect(content().string("Love - Love"));
    }

    @Test
    void shouldUpdateScoreWhenPlayerScores() throws Exception {
        mockMvc.perform(post("/api/tennis/new-game")
                        .param("player1", "Hannibal")
                        .param("player2", "Clarice")
                )
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/tennis/point/Hannibal"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fifteen - Love"));

        mockMvc.perform(post("/api/tennis/point/Clarice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fifteen - Fifteen"));
    }
}
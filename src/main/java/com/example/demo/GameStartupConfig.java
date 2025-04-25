package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.openapitools.client.api.DefaultApi;      
import org.openapitools.client.ApiClient;
import org.openapitools.client.model.GameDto;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;                           

@Configuration
@Component
public class GameStartupConfig {

    private static final Logger logger = LoggerFactory.getLogger(GameStartupConfig.class);
    
    @Value("${game.api.basePath:http://localhost:8080}")
    private String apiBasePath;

    private final DefaultApi gameApi;

    public GameStartupConfig() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(apiBasePath);
        this.gameApi = new DefaultApi(apiClient);
    }
    @Bean
    CommandLineRunner initGame() {
        return args -> {
            System.out.println("🎮 Initialisiere neues Spiel...");
            createNewGame();
        };
    }

    private void createNewGame() {
        try {
            GameDto newGame = gameApi.createGame(null);
            logger.info("Neues Spiel erstellt! Game ID: {}", newGame.getId());
            logger.info("Spieler startet auf Position: {}{}", 
                newGame.getPlayerPosition().getColumn(), 
                newGame.getPlayerPosition().getRow());
        } catch (Exception err) {
            logger.error("Fehler beim Erstellen des Spiels:{}", err.getMessage());
        }
    }
}
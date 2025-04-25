package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.GameDto;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;                           

@Configuration
@Component
public class StartupBean {

    private static final Logger logger = LoggerFactory.getLogger(StartupBean.class);

    @PostConstruct
    public void init() {
        DefaultApi defaultApi = new DefaultApi();

        try {
            GameDto result = defaultApi.createGame(null);
            System.out.println("🕹️ Ein neues Spiel wurde erstellt!");
        } catch (Exception err) {
            logger.error("Fehler beim Erstellen des Spiels:{}", err.getMessage());
        }
    }
}
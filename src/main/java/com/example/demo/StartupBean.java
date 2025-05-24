
package com.example.demo;

import com.example.demo.service.AutoPlayerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Configuration
@Component
public class StartupBean {

    private static final Logger logger = LoggerFactory.getLogger(StartupBean.class);

    @Autowired
    private AutoPlayerService autoPlayerService;

    @PostConstruct
    public void init() {
        logger.info("🚀 Portfolio 3 - 5x5 Labyrinth-Spiel gestartet!");
        logger.info("👨‍💻 Erstellt von Sebastian Wolf, Mart.Nr: 6771635");

        new Thread(() -> {
            try {
                Thread.sleep(2000); // 2 Sekunden
                logger.info("Starte Spieler...");
                autoPlayerService.playGameAutomatically();
            } catch (InterruptedException e) {
                logger.error("Fehler beim starten vom Spieler: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
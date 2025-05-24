package com.example.demo.service;

import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutoPlayerService {

    private static final Logger logger = LoggerFactory.getLogger(AutoPlayerService.class);

    public void playGameAutomatically() {
        DefaultApi api = new DefaultApi();
        api.getApiClient().setBasePath("http://localhost:8080");

        try {
            logger.info("Erstelle neues Spiel...");
            CreateGameRequestDto createRequest = new CreateGameRequestDto();
            createRequest.setLabyrinthType(CreateGameRequestDto.LabyrinthTypeEnum.RANDOM);
            createRequest.setDifficulty(CreateGameRequestDto.DifficultyEnum.MEDIUM);

            GameDto game = api.createGame(createRequest);
            UUID gameId = game.getId();
            logger.info("Spiel erstellt! ID: {}", gameId);
            logger.info("Startposition: {}{}", game.getPlayerPosition().getColumn().getValue(), game.getPlayerPosition().getRow());

            BoardDto board = api.getGameBoard(gameId);
            displayBoard(board);

            logger.info("Finde Lösung...");
            SolutionDto solution = api.getSolution(gameId);

            List<String> directionStrings = solution.getDirections().stream()
                    .map(dir -> dir.getValue())
                    .toList();

            logger.info("Lösungsweg gefunden. Benötigte Schritte: {}",
                    solution.getStepsToGoal(), directionStrings);

            logger.info("Beginne.....");
            List<SolutionDto.DirectionsEnum> directions = solution.getDirections();

            for (int i = 0; i < directions.size(); i++) {
                SolutionDto.DirectionsEnum direction = directions.get(i);
                logger.info("Schritt {}/{}: Bewegegung {}", i + 1, directions.size(), direction.getValue());

                MoveRequestDto moveRequest = new MoveRequestDto();
                moveRequest.setDirection(MoveRequestDto.DirectionEnum.fromValue(direction.getValue()));

                MoveResponseDto moveResponse = api.movePlayer(gameId, moveRequest);

                if (moveResponse.getSuccess()) {
                    PositionDto newPos = moveResponse.getNewPosition();
                    logger.info("Erfolgreiche Bewegung! Neue Position: {}{}",
                            newPos.getColumn().getValue(), newPos.getRow());

                    if (moveResponse.getGameStatus() == MoveResponseDto.GameStatusEnum.SUCCESS) {
                        logger.info("Gewonnen! {}", moveResponse.getMessage());

                        GameDto finalGame = api.getGameStatus(gameId);
                        logger.info("Statistiken:");
                        logger.info("   - Anzahl Züge: {}", finalGame.getMoves());
                        logger.info("   - Status: {}", finalGame.getStatus().getValue());
                        logger.info("   - Nachricht: {}", finalGame.getMessage());

                        return;
                    }
                } else {
                    logger.warn("❌ Bewegung fehlgeschlagen: {}", moveResponse.getMessage());
                }

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            logger.error("Fehler beim Spielen: {}", e.getMessage(), e);
        }
    }

    private void displayBoard(BoardDto board) {
        logger.info("Labyrinth-Spielfeld (5x5):");
        logger.info("Spieler: {}{}",
                board.getPlayerPosition().getColumn().getValue(),
                board.getPlayerPosition().getRow());
        logger.info("Ziel: {}{}",
                board.getGoal().getColumn().getValue(),
                board.getGoal().getRow());
        logger.info("Anzahl Wände: {}", board.getWalls().size());

        if (!board.getWalls().isEmpty()) {
            logger.info("Wände:");
            for (WallDto wall : board.getWalls()) {
                logger.info("     - {}{} <-> {}{}",
                        wall.getPosition1().getColumn().getValue(), wall.getPosition1().getRow(),
                        wall.getPosition2().getColumn().getValue(), wall.getPosition2().getRow());
            }
        }
    }
}
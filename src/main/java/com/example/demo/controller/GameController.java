package com.example.demo.controller;

import com.example.demo.service.GameService;
import org.openapitools.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public ResponseEntity<GameDto> createGame(@RequestBody(required = false) CreateGameRequestDto request) {
        try {
            GameDto game = gameService.createGame(request);
            return new ResponseEntity<>(game, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<GameDto> getGameStatus(@PathVariable UUID gameId) {
        try {
            GameDto game = gameService.getGameStatus(gameId);
            if (game != null) {
                return ResponseEntity.ok(game);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/game/{gameId}/move")
    public ResponseEntity<MoveResponseDto> movePlayer(@PathVariable UUID gameId, @RequestBody MoveRequestDto request) {
        try {
            MoveResponseDto response = gameService.movePlayer(gameId, request);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/game/{gameId}/board")
    public ResponseEntity<BoardDto> getGameBoard(@PathVariable UUID gameId) {
        try {
            BoardDto board = gameService.getGameBoard(gameId);
            if (board != null) {
                return ResponseEntity.ok(board);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/game/{gameId}/labyrinth")
    public ResponseEntity<BoardDto> createLabyrinth(@PathVariable UUID gameId, @RequestBody(required = false) CreateLabyrinthRequestDto request) {
        try {
            BoardDto board = gameService.createLabyrinth(gameId, request);
            if (board != null) {
                return ResponseEntity.ok(board);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/game/{gameId}/hint")
    public ResponseEntity<HintDto> getHint(@PathVariable UUID gameId) {
        try {
            HintDto hint = gameService.getHint(gameId);
            if (hint != null) {
                return ResponseEntity.ok(hint);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/game/{gameId}/solution")
    public ResponseEntity<SolutionDto> getSolution(@PathVariable UUID gameId) {
        try {
            SolutionDto solution = gameService.getSolution(gameId);
            if (solution != null) {
                return ResponseEntity.ok(solution);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/game/{gameId}/reset")
    public ResponseEntity<GameDto> resetGame(@PathVariable UUID gameId) {
        try {
            GameDto game = gameService.resetGame(gameId);
            if (game != null) {
                return ResponseEntity.ok(game);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
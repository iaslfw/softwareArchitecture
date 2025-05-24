package com.example.demo.service;

import org.openapitools.client.model.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private Map<UUID, Game> games = new ConcurrentHashMap<>();
    private Random random = new Random();

    public GameDto createGame(CreateGameRequestDto request) {
        UUID gameId = UUID.randomUUID();
        Game game = new Game();
        game.setId(gameId);
        game.setStatus(GameDto.StatusEnum.RUNNING);
        game.setPlayerPosition(createPosition(PositionDto.ColumnEnum.A, 1));
        game.setGoal(createPosition(PositionDto.ColumnEnum.E, 5));
        game.setMoves(0);
        game.setMessage("Spiel erstellt! Start: A1, Ziel: E5.");

        CreateGameRequestDto.DifficultyEnum difficulty = request != null && request.getDifficulty() != null
                ? request.getDifficulty()
                : CreateGameRequestDto.DifficultyEnum.MEDIUM;

        CreateGameRequestDto.LabyrinthTypeEnum labyrinthType = request != null && request.getLabyrinthType() != null
                ? request.getLabyrinthType()
                : CreateGameRequestDto.LabyrinthTypeEnum.RANDOM;

        if (labyrinthType == CreateGameRequestDto.LabyrinthTypeEnum.RANDOM) {
            createRandomLabyrinth(game, difficulty);
        } else {
            createDefaultLabyrinth(game);
        }

        games.put(gameId, game);
        return convertToGameDto(game);
    }

    public GameDto getGameStatus(UUID gameId) {
        Game game = games.get(gameId);
        return game != null ? convertToGameDto(game) : null;
    }

    public MoveResponseDto movePlayer(UUID gameId, MoveRequestDto request) {
        Game game = games.get(gameId);
        if (game == null) return null;

        PositionDto currentPos = game.getPlayerPosition();
        PositionDto newPos = calculateNewPosition(currentPos, request.getDirection());

        MoveResponseDto response = new MoveResponseDto();

        if (isWallBetween(currentPos, newPos, game.getWalls()) || isOutOfBounds(newPos)) {
            response.setSuccess(false);
            response.setNewPosition(currentPos);
            response.setWallHit(true);
            response.setMessage("Bewegung ungültig. Blockiert durch Wand oder outside of map!");
            response.setGameStatus(MoveResponseDto.GameStatusEnum.fromValue(game.getStatus().getValue()));
        } else {
            game.setPlayerPosition(newPos);
            game.setMoves(game.getMoves() + 1);
            game.getVisited().add(newPos);

            response.setSuccess(true);
            response.setNewPosition(newPos);
            response.setWallHit(false);

            if (isPositionEqual(newPos, game.getGoal())) {
                game.setStatus(GameDto.StatusEnum.SUCCESS);
                response.setMessage("Nice! Ziel erreicht in " + game.getMoves() + " Zügen!");
                response.setGameStatus(MoveResponseDto.GameStatusEnum.SUCCESS);
            } else {
                response.setMessage("Bewegung erfolgreich!");
                response.setGameStatus(MoveResponseDto.GameStatusEnum.RUNNING);
            }
        }

        return response;
    }

    public BoardDto getGameBoard(UUID gameId) {
        Game game = games.get(gameId);
        if (game == null) return null;

        BoardDto board = new BoardDto();

        BoardSizeDto size = new BoardSizeDto();
        size.setColumns(BoardSizeDto.ColumnsEnum.NUMBER_5);
        size.setRows(BoardSizeDto.RowsEnum.NUMBER_5);
        board.setSize(size);

        board.setPlayerPosition(game.getPlayerPosition());
        board.setGoal(game.getGoal());
        board.setWalls(game.getWalls());
        board.setVisited(game.getVisited());

        return board;
    }

    public BoardDto createLabyrinth(UUID gameId, CreateLabyrinthRequestDto request) {
        Game game = games.get(gameId);
        if (game == null) return null;

        if (request != null && request.getType() == CreateLabyrinthRequestDto.TypeEnum.PREDEFINED && request.getWalls() != null) {
            game.setWalls(request.getWalls());
        } else {
            CreateLabyrinthRequestDto.DifficultyEnum difficulty = request != null && request.getDifficulty() != null
                    ? CreateLabyrinthRequestDto.DifficultyEnum.valueOf(request.getDifficulty().getValue().toUpperCase())
                    : CreateLabyrinthRequestDto.DifficultyEnum.MEDIUM;

            CreateGameRequestDto.DifficultyEnum gameDifficulty = CreateGameRequestDto.DifficultyEnum.valueOf(difficulty.getValue().toUpperCase());
            createRandomLabyrinth(game, gameDifficulty);
        }

        return getGameBoard(gameId);
    }

    public HintDto getHint(UUID gameId) {
        Game game = games.get(gameId);
        if (game == null) return null;

        List<MoveRequestDto.DirectionEnum> path = findPath(game.getPlayerPosition(), game.getGoal(), game.getWalls());

        HintDto hint = new HintDto();
        if (!path.isEmpty()) {
            MoveRequestDto.DirectionEnum nextDirection = path.get(0);
            hint.setSuggestedDirection(HintDto.SuggestedDirectionEnum.fromValue(nextDirection.getValue()));
            hint.setMessage("Empfholener Schritt: " + nextDirection.getValue());
        } else {
            hint.setMessage("Du hast das Ziel erreich!");
        }

        return hint;
    }

    public SolutionDto getSolution(UUID gameId) {
        Game game = games.get(gameId);
        if (game == null) return null;

        List<MoveRequestDto.DirectionEnum> directions = findPath(game.getPlayerPosition(), game.getGoal(), game.getWalls());
        List<PositionDto> path = calculatePath(game.getPlayerPosition(), directions);

        SolutionDto solution = new SolutionDto();

        List<SolutionDto.DirectionsEnum> solutionDirections = new ArrayList<>();
        for (MoveRequestDto.DirectionEnum dir : directions) {
            solutionDirections.add(SolutionDto.DirectionsEnum.fromValue(dir.getValue()));
        }

        solution.setDirections(solutionDirections);
        solution.setPath(path);
        solution.setStepsToGoal(directions.size());

        return solution;
    }

    public GameDto resetGame(UUID gameId) {
        Game game = games.get(gameId);
        if (game == null) return null;

        game.setPlayerPosition(createPosition(PositionDto.ColumnEnum.A, 1));
        game.setMoves(0);
        game.setStatus(GameDto.StatusEnum.RUNNING);
        game.setMessage("Spiel zurückgesetzt!");
        game.getVisited().clear();
        game.getVisited().add(game.getPlayerPosition());

        return convertToGameDto(game);
    }

    private void createRandomLabyrinth(Game game, CreateGameRequestDto.DifficultyEnum difficulty) {
        int maxAttempts = 50;
        int attempts = 0;

        while (attempts < maxAttempts) {
            List<WallDto> walls = generateRandomWalls(difficulty);

            if (hasValidPath(game.getPlayerPosition(), game.getGoal(), walls)) {
                game.setWalls(walls);
                game.setVisited(new ArrayList<>());
                game.getVisited().add(game.getPlayerPosition());
                return;
            }

            attempts++;
        }

        createDefaultLabyrinth(game);
    }

    private List<WallDto> generateRandomWalls(CreateGameRequestDto.DifficultyEnum difficulty) {
        List<WallDto> walls = new ArrayList<>();
        Set<String> usedWalls = new HashSet<>();

        int minWalls, maxWalls;
        switch (difficulty) {
            case EASY:
                minWalls = 3;
                maxWalls = 5;
                break;
            case HARD:
                minWalls = 8;
                maxWalls = 12;
                break;
            case MEDIUM:
            default:
                minWalls = 5;
                maxWalls = 8;
                break;
        }

        int numWalls = random.nextInt(maxWalls - minWalls + 1) + minWalls;

        List<WallDto> possibleWalls = getAllPossibleWalls();

        Collections.shuffle(possibleWalls, random);

        for (int i = 0; i < Math.min(numWalls, possibleWalls.size()); i++) {
            WallDto wall = possibleWalls.get(i);
            String wallKey = getWallKey(wall);

            if (!usedWalls.contains(wallKey)) {
                walls.add(wall);
                usedWalls.add(wallKey);
            }
        }

        return walls;
    }

    private List<WallDto> getAllPossibleWalls() {
        List<WallDto> possibleWalls = new ArrayList<>();
        PositionDto.ColumnEnum[] columns = PositionDto.ColumnEnum.values();

        for (PositionDto.ColumnEnum col : columns) {
            for (int row = 1; row <= 4; row++) {
                possibleWalls.add(createWall(col, row, col, row + 1));
            }
        }

        for (int row = 1; row <= 5; row++) {
            for (int colIndex = 0; colIndex < columns.length - 1; colIndex++) {
                possibleWalls.add(createWall(columns[colIndex], row, columns[colIndex + 1], row));
            }
        }

        return possibleWalls;
    }

    private String getWallKey(WallDto wall) {
        PositionDto pos1 = wall.getPosition1();
        PositionDto pos2 = wall.getPosition2();

        String key1 = pos1.getColumn().getValue() + pos1.getRow();
        String key2 = pos2.getColumn().getValue() + pos2.getRow();

        return key1.compareTo(key2) <= 0 ? key1 + "-" + key2 : key2 + "-" + key1;
    }

    private boolean hasValidPath(PositionDto start, PositionDto goal, List<WallDto> walls) {
        List<MoveRequestDto.DirectionEnum> path = findPath(start, goal, walls);
        return !path.isEmpty();
    }

    private void createDefaultLabyrinth(Game game) {
        List<WallDto> walls = new ArrayList<>();

        walls.add(createWall(PositionDto.ColumnEnum.A, 1, PositionDto.ColumnEnum.A, 2));
        walls.add(createWall(PositionDto.ColumnEnum.B, 2, PositionDto.ColumnEnum.C, 2));
        walls.add(createWall(PositionDto.ColumnEnum.D, 1, PositionDto.ColumnEnum.D, 2));
        walls.add(createWall(PositionDto.ColumnEnum.B, 3, PositionDto.ColumnEnum.B, 4));
        walls.add(createWall(PositionDto.ColumnEnum.C, 4, PositionDto.ColumnEnum.D, 4));

        game.setWalls(walls);
        game.setVisited(new ArrayList<>());
        game.getVisited().add(game.getPlayerPosition());
    }

    private WallDto createWall(PositionDto.ColumnEnum col1, int row1, PositionDto.ColumnEnum col2, int row2) {
        WallDto wall = new WallDto();
        wall.setPosition1(createPosition(col1, row1));
        wall.setPosition2(createPosition(col2, row2));
        return wall;
    }

    private PositionDto createPosition(PositionDto.ColumnEnum column, int row) {
        PositionDto pos = new PositionDto();
        pos.setColumn(column);
        pos.setRow(row);
        return pos;
    }

    private PositionDto calculateNewPosition(PositionDto current, MoveRequestDto.DirectionEnum direction) {
        PositionDto.ColumnEnum currentCol = current.getColumn();
        int currentRow = current.getRow();

        switch (direction) {
            case OBEN:
                return createPosition(currentCol, currentRow - 1);
            case UNTEN:
                return createPosition(currentCol, currentRow + 1);
            case LINKS:
                PositionDto.ColumnEnum prevCol = getPreviousColumn(currentCol);
                return prevCol != null ? createPosition(prevCol, currentRow) : current;
            case RECHTS:
                PositionDto.ColumnEnum nextCol = getNextColumn(currentCol);
                return nextCol != null ? createPosition(nextCol, currentRow) : current;
            default:
                return current;
        }
    }

    private PositionDto.ColumnEnum getPreviousColumn(PositionDto.ColumnEnum col) {
        switch (col) {
            case B: return PositionDto.ColumnEnum.A;
            case C: return PositionDto.ColumnEnum.B;
            case D: return PositionDto.ColumnEnum.C;
            case E: return PositionDto.ColumnEnum.D;
            default: return null;
        }
    }

    private PositionDto.ColumnEnum getNextColumn(PositionDto.ColumnEnum col) {
        switch (col) {
            case A: return PositionDto.ColumnEnum.B;
            case B: return PositionDto.ColumnEnum.C;
            case C: return PositionDto.ColumnEnum.D;
            case D: return PositionDto.ColumnEnum.E;
            default: return null;
        }
    }

    private boolean isOutOfBounds(PositionDto pos) {
        if (pos.getColumn() == null || pos.getRow() == null) return true;
        return pos.getRow() < 1 || pos.getRow() > 5;
    }

    private boolean isWallBetween(PositionDto pos1, PositionDto pos2, List<WallDto> walls) {
        for (WallDto wall : walls) {
            if ((isPositionEqual(wall.getPosition1(), pos1) && isPositionEqual(wall.getPosition2(), pos2)) ||
                    (isPositionEqual(wall.getPosition1(), pos2) && isPositionEqual(wall.getPosition2(), pos1))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPositionEqual(PositionDto pos1, PositionDto pos2) {
        return pos1.getColumn() == pos2.getColumn() && pos1.getRow().equals(pos2.getRow());
    }

    private List<MoveRequestDto.DirectionEnum> findPath(PositionDto start, PositionDto goal, List<WallDto> walls) {
        Queue<PathNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new PathNode(start, new ArrayList<>()));
        visited.add(positionToString(start));

        MoveRequestDto.DirectionEnum[] directions = {
                MoveRequestDto.DirectionEnum.OBEN,
                MoveRequestDto.DirectionEnum.UNTEN,
                MoveRequestDto.DirectionEnum.LINKS,
                MoveRequestDto.DirectionEnum.RECHTS
        };

        while (!queue.isEmpty()) {
            PathNode current = queue.poll();

            if (isPositionEqual(current.position, goal)) {
                return current.path;
            }

            for (MoveRequestDto.DirectionEnum direction : directions) {
                PositionDto newPos = calculateNewPosition(current.position, direction);

                if (!isOutOfBounds(newPos) &&
                        !isWallBetween(current.position, newPos, walls) &&
                        !visited.contains(positionToString(newPos))) {

                    List<MoveRequestDto.DirectionEnum> newPath = new ArrayList<>(current.path);
                    newPath.add(direction);

                    queue.offer(new PathNode(newPos, newPath));
                    visited.add(positionToString(newPos));
                }
            }
        }

        return new ArrayList<>();
    }

    private List<PositionDto> calculatePath(PositionDto start, List<MoveRequestDto.DirectionEnum> directions) {
        List<PositionDto> path = new ArrayList<>();
        PositionDto current = start;
        path.add(current);

        for (MoveRequestDto.DirectionEnum direction : directions) {
            current = calculateNewPosition(current, direction);
            path.add(current);
        }

        return path;
    }

    private String positionToString(PositionDto pos) {
        return pos.getColumn().getValue() + pos.getRow();
    }

    private GameDto convertToGameDto(Game game) {
        GameDto dto = new GameDto();
        dto.setId(game.getId());
        dto.setStatus(game.getStatus());
        dto.setPlayerPosition(game.getPlayerPosition());
        dto.setMoves(game.getMoves());
        dto.setMessage(game.getMessage());
        return dto;
    }

    private static class Game {
        private UUID id;
        private GameDto.StatusEnum status;
        private PositionDto playerPosition;
        private PositionDto goal;
        private Integer moves;
        private String message;
        private List<WallDto> walls;
        private List<PositionDto> visited;

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }
        public GameDto.StatusEnum getStatus() { return status; }
        public void setStatus(GameDto.StatusEnum status) { this.status = status; }
        public PositionDto getPlayerPosition() { return playerPosition; }
        public void setPlayerPosition(PositionDto playerPosition) { this.playerPosition = playerPosition; }
        public PositionDto getGoal() { return goal; }
        public void setGoal(PositionDto goal) { this.goal = goal; }
        public Integer getMoves() { return moves; }
        public void setMoves(Integer moves) { this.moves = moves; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public List<WallDto> getWalls() { return walls; }
        public void setWalls(List<WallDto> walls) { this.walls = walls; }
        public List<PositionDto> getVisited() { return visited; }
        public void setVisited(List<PositionDto> visited) { this.visited = visited; }
    }

    private static class PathNode {
        PositionDto position;
        List<MoveRequestDto.DirectionEnum> path;

        PathNode(PositionDto position, List<MoveRequestDto.DirectionEnum> path) {
            this.position = position;
            this.path = path;
        }
    }
}
package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.BoardDto;
import org.openapitools.client.model.CreateGameRequestDto;
import org.openapitools.client.model.CreateLabyrinthRequestDto;
import org.openapitools.client.model.ErrorDto;
import org.openapitools.client.model.GameDto;
import org.openapitools.client.model.HintDto;
import org.openapitools.client.model.MoveRequestDto;
import org.openapitools.client.model.MoveResponseDto;
import org.openapitools.client.model.SolutionDto;
import java.util.UUID;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient.ResponseSpec;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-24T10:47:41.163385+02:00[Europe/Berlin]", comments = "Generator version: 7.10.0")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Erstelle ein neues Labyrinth-Spiel
     * Startee ein neues Spiel mit dem Spieler auf Position A1 und dem Ziel auf E5
     * <p><b>201</b> - Labyrinth-Spiel erfolgreich erstellt
     * <p><b>500</b> - Serverfehler
     * @param createGameRequestDto The createGameRequestDto parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createGameRequestCreation(CreateGameRequestDto createGameRequestDto) throws RestClientResponseException {
        Object postBody = createGameRequestDto;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth-Spiel
     * Startee ein neues Spiel mit dem Spieler auf Position A1 und dem Ziel auf E5
     * <p><b>201</b> - Labyrinth-Spiel erfolgreich erstellt
     * <p><b>500</b> - Serverfehler
     * @param createGameRequestDto The createGameRequestDto parameter
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public GameDto createGame(CreateGameRequestDto createGameRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createGameRequestCreation(createGameRequestDto).body(localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth-Spiel
     * Startee ein neues Spiel mit dem Spieler auf Position A1 und dem Ziel auf E5
     * <p><b>201</b> - Labyrinth-Spiel erfolgreich erstellt
     * <p><b>500</b> - Serverfehler
     * @param createGameRequestDto The createGameRequestDto parameter
     * @return ResponseEntity&lt;GameDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GameDto> createGameWithHttpInfo(CreateGameRequestDto createGameRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createGameRequestCreation(createGameRequestDto).toEntity(localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth-Spiel
     * Startee ein neues Spiel mit dem Spieler auf Position A1 und dem Ziel auf E5
     * <p><b>201</b> - Labyrinth-Spiel erfolgreich erstellt
     * <p><b>500</b> - Serverfehler
     * @param createGameRequestDto The createGameRequestDto parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createGameWithResponseSpec(CreateGameRequestDto createGameRequestDto) throws RestClientResponseException {
        return createGameRequestCreation(createGameRequestDto);
    }
    /**
     * Erstelle ein neues Labyrinth für das aktuelle Spiel
     * Generiere ein neues Labyrinth mit Wänden zwischen den Feldern
     * <p><b>200</b> - Labyrinth erfolgreich erstellt
     * <p><b>400</b> - Ungültige Labyrinth-Konfiguration
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param createLabyrinthRequestDto The createLabyrinthRequestDto parameter
     * @return BoardDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createLabyrinthRequestCreation(UUID gameId, CreateLabyrinthRequestDto createLabyrinthRequestDto) throws RestClientResponseException {
        Object postBody = createLabyrinthRequestDto;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling createLabyrinth", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/labyrinth", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth für das aktuelle Spiel
     * Generiere ein neues Labyrinth mit Wänden zwischen den Feldern
     * <p><b>200</b> - Labyrinth erfolgreich erstellt
     * <p><b>400</b> - Ungültige Labyrinth-Konfiguration
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param createLabyrinthRequestDto The createLabyrinthRequestDto parameter
     * @return BoardDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public BoardDto createLabyrinth(UUID gameId, CreateLabyrinthRequestDto createLabyrinthRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createLabyrinthRequestCreation(gameId, createLabyrinthRequestDto).body(localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth für das aktuelle Spiel
     * Generiere ein neues Labyrinth mit Wänden zwischen den Feldern
     * <p><b>200</b> - Labyrinth erfolgreich erstellt
     * <p><b>400</b> - Ungültige Labyrinth-Konfiguration
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param createLabyrinthRequestDto The createLabyrinthRequestDto parameter
     * @return ResponseEntity&lt;BoardDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BoardDto> createLabyrinthWithHttpInfo(UUID gameId, CreateLabyrinthRequestDto createLabyrinthRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createLabyrinthRequestCreation(gameId, createLabyrinthRequestDto).toEntity(localVarReturnType);
    }

    /**
     * Erstelle ein neues Labyrinth für das aktuelle Spiel
     * Generiere ein neues Labyrinth mit Wänden zwischen den Feldern
     * <p><b>200</b> - Labyrinth erfolgreich erstellt
     * <p><b>400</b> - Ungültige Labyrinth-Konfiguration
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param createLabyrinthRequestDto The createLabyrinthRequestDto parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createLabyrinthWithResponseSpec(UUID gameId, CreateLabyrinthRequestDto createLabyrinthRequestDto) throws RestClientResponseException {
        return createLabyrinthRequestCreation(gameId, createLabyrinthRequestDto);
    }
    /**
     * Gibe das aktuelle Labyrinth-Spielfeld zurück
     * Liefere Informationen über das Labyrinth einschließlich aller Wände, der Position des Spielers und des Ziels
     * <p><b>200</b> - Labyrinth erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return BoardDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getGameBoardRequestCreation(UUID gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling getGameBoard", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/board", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Gibe das aktuelle Labyrinth-Spielfeld zurück
     * Liefere Informationen über das Labyrinth einschließlich aller Wände, der Position des Spielers und des Ziels
     * <p><b>200</b> - Labyrinth erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return BoardDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public BoardDto getGameBoard(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getGameBoardRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Gibe das aktuelle Labyrinth-Spielfeld zurück
     * Liefere Informationen über das Labyrinth einschließlich aller Wände, der Position des Spielers und des Ziels
     * <p><b>200</b> - Labyrinth erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseEntity&lt;BoardDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BoardDto> getGameBoardWithHttpInfo(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<BoardDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getGameBoardRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Gibe das aktuelle Labyrinth-Spielfeld zurück
     * Liefere Informationen über das Labyrinth einschließlich aller Wände, der Position des Spielers und des Ziels
     * <p><b>200</b> - Labyrinth erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getGameBoardWithResponseSpec(UUID gameId) throws RestClientResponseException {
        return getGameBoardRequestCreation(gameId);
    }
    /**
     * Gib den aktuellen Spielstatus zurück
     * Liefere Informationen über den aktuellen Zustand des Spiels
     * <p><b>200</b> - Spielstatus erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getGameStatusRequestCreation(UUID gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling getGameStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Gib den aktuellen Spielstatus zurück
     * Liefere Informationen über den aktuellen Zustand des Spiels
     * <p><b>200</b> - Spielstatus erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public GameDto getGameStatus(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getGameStatusRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Gib den aktuellen Spielstatus zurück
     * Liefere Informationen über den aktuellen Zustand des Spiels
     * <p><b>200</b> - Spielstatus erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseEntity&lt;GameDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GameDto> getGameStatusWithHttpInfo(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getGameStatusRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Gib den aktuellen Spielstatus zurück
     * Liefere Informationen über den aktuellen Zustand des Spiels
     * <p><b>200</b> - Spielstatus erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getGameStatusWithResponseSpec(UUID gameId) throws RestClientResponseException {
        return getGameStatusRequestCreation(gameId);
    }
    /**
     * Gib einen Hinweis zur Lösung des Labyrinths
     * Liefere einen Hinweis oder den nächsten Schritt auf dem Lösungsweg
     * <p><b>200</b> - Hinweis erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return HintDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getHintRequestCreation(UUID gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling getHint", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<HintDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/hint", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Gib einen Hinweis zur Lösung des Labyrinths
     * Liefere einen Hinweis oder den nächsten Schritt auf dem Lösungsweg
     * <p><b>200</b> - Hinweis erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return HintDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public HintDto getHint(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<HintDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getHintRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Gib einen Hinweis zur Lösung des Labyrinths
     * Liefere einen Hinweis oder den nächsten Schritt auf dem Lösungsweg
     * <p><b>200</b> - Hinweis erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseEntity&lt;HintDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HintDto> getHintWithHttpInfo(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<HintDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getHintRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Gib einen Hinweis zur Lösung des Labyrinths
     * Liefere einen Hinweis oder den nächsten Schritt auf dem Lösungsweg
     * <p><b>200</b> - Hinweis erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getHintWithResponseSpec(UUID gameId) throws RestClientResponseException {
        return getHintRequestCreation(gameId);
    }
    /**
     * Gib die komplette Lösung des Labyrinths zurück
     * Liefere den vollständigen Lösungsweg von der aktuellen Position zum Ziel
     * <p><b>200</b> - Lösung erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden oder keine Lösung möglich
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return SolutionDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSolutionRequestCreation(UUID gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling getSolution", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<SolutionDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/solution", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Gib die komplette Lösung des Labyrinths zurück
     * Liefere den vollständigen Lösungsweg von der aktuellen Position zum Ziel
     * <p><b>200</b> - Lösung erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden oder keine Lösung möglich
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return SolutionDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public SolutionDto getSolution(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<SolutionDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getSolutionRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Gib die komplette Lösung des Labyrinths zurück
     * Liefere den vollständigen Lösungsweg von der aktuellen Position zum Ziel
     * <p><b>200</b> - Lösung erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden oder keine Lösung möglich
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseEntity&lt;SolutionDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SolutionDto> getSolutionWithHttpInfo(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<SolutionDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getSolutionRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Gib die komplette Lösung des Labyrinths zurück
     * Liefere den vollständigen Lösungsweg von der aktuellen Position zum Ziel
     * <p><b>200</b> - Lösung erfolgreich zurückgegeben
     * <p><b>404</b> - Spiel nicht gefunden oder keine Lösung möglich
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSolutionWithResponseSpec(UUID gameId) throws RestClientResponseException {
        return getSolutionRequestCreation(gameId);
    }
    /**
     * Führe einen Spielzug aus
     * Bewegt den Spieler in eine der vier möglichen Richtungen unter Berücksichtigung der Labyrinthwände
     * <p><b>200</b> - Bewegung erfolgreich durchgeführt oder verhindert durch Labyrinthwand
     * <p><b>400</b> - Ungültige Bewegungsrichtung
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param moveRequestDto The moveRequestDto parameter
     * @return MoveResponseDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec movePlayerRequestCreation(UUID gameId, MoveRequestDto moveRequestDto) throws RestClientResponseException {
        Object postBody = moveRequestDto;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling movePlayer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'moveRequestDto' is set
        if (moveRequestDto == null) {
            throw new RestClientResponseException("Missing the required parameter 'moveRequestDto' when calling movePlayer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<MoveResponseDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/move", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Führe einen Spielzug aus
     * Bewegt den Spieler in eine der vier möglichen Richtungen unter Berücksichtigung der Labyrinthwände
     * <p><b>200</b> - Bewegung erfolgreich durchgeführt oder verhindert durch Labyrinthwand
     * <p><b>400</b> - Ungültige Bewegungsrichtung
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param moveRequestDto The moveRequestDto parameter
     * @return MoveResponseDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public MoveResponseDto movePlayer(UUID gameId, MoveRequestDto moveRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<MoveResponseDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return movePlayerRequestCreation(gameId, moveRequestDto).body(localVarReturnType);
    }

    /**
     * Führe einen Spielzug aus
     * Bewegt den Spieler in eine der vier möglichen Richtungen unter Berücksichtigung der Labyrinthwände
     * <p><b>200</b> - Bewegung erfolgreich durchgeführt oder verhindert durch Labyrinthwand
     * <p><b>400</b> - Ungültige Bewegungsrichtung
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param moveRequestDto The moveRequestDto parameter
     * @return ResponseEntity&lt;MoveResponseDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<MoveResponseDto> movePlayerWithHttpInfo(UUID gameId, MoveRequestDto moveRequestDto) throws RestClientResponseException {
        ParameterizedTypeReference<MoveResponseDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return movePlayerRequestCreation(gameId, moveRequestDto).toEntity(localVarReturnType);
    }

    /**
     * Führe einen Spielzug aus
     * Bewegt den Spieler in eine der vier möglichen Richtungen unter Berücksichtigung der Labyrinthwände
     * <p><b>200</b> - Bewegung erfolgreich durchgeführt oder verhindert durch Labyrinthwand
     * <p><b>400</b> - Ungültige Bewegungsrichtung
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @param moveRequestDto The moveRequestDto parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec movePlayerWithResponseSpec(UUID gameId, MoveRequestDto moveRequestDto) throws RestClientResponseException {
        return movePlayerRequestCreation(gameId, moveRequestDto);
    }
    /**
     * Setze das Spiel zurück
     * Setzt den Spieler auf die Startposition A1 zurück, behält aber das Labyrinth bei
     * <p><b>200</b> - Spiel erfolgreich zurückgesetzt
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec resetGameRequestCreation(UUID gameId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new RestClientResponseException("Missing the required parameter 'gameId' when calling resetGame", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("gameId", gameId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/game/{gameId}/reset", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Setze das Spiel zurück
     * Setzt den Spieler auf die Startposition A1 zurück, behält aber das Labyrinth bei
     * <p><b>200</b> - Spiel erfolgreich zurückgesetzt
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return GameDto
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public GameDto resetGame(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return resetGameRequestCreation(gameId).body(localVarReturnType);
    }

    /**
     * Setze das Spiel zurück
     * Setzt den Spieler auf die Startposition A1 zurück, behält aber das Labyrinth bei
     * <p><b>200</b> - Spiel erfolgreich zurückgesetzt
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseEntity&lt;GameDto&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GameDto> resetGameWithHttpInfo(UUID gameId) throws RestClientResponseException {
        ParameterizedTypeReference<GameDto> localVarReturnType = new ParameterizedTypeReference<>() {};
        return resetGameRequestCreation(gameId).toEntity(localVarReturnType);
    }

    /**
     * Setze das Spiel zurück
     * Setzt den Spieler auf die Startposition A1 zurück, behält aber das Labyrinth bei
     * <p><b>200</b> - Spiel erfolgreich zurückgesetzt
     * <p><b>404</b> - Spiel nicht gefunden
     * <p><b>500</b> - Serverfehler
     * @param gameId ID des Spiels
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec resetGameWithResponseSpec(UUID gameId) throws RestClientResponseException {
        return resetGameRequestCreation(gameId);
    }
}

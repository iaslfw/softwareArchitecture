# DefaultApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createGame**](DefaultApi.md#createGame) | **POST** /game | Erstelle ein neues Labyrinth-Spiel |
| [**createLabyrinth**](DefaultApi.md#createLabyrinth) | **POST** /game/{gameId}/labyrinth | Erstelle ein neues Labyrinth für das aktuelle Spiel |
| [**getGameBoard**](DefaultApi.md#getGameBoard) | **GET** /game/{gameId}/board | Gibe das aktuelle Labyrinth-Spielfeld zurück |
| [**getGameStatus**](DefaultApi.md#getGameStatus) | **GET** /game/{gameId} | Gib den aktuellen Spielstatus zurück |
| [**getHint**](DefaultApi.md#getHint) | **GET** /game/{gameId}/hint | Gib einen Hinweis zur Lösung des Labyrinths |
| [**getSolution**](DefaultApi.md#getSolution) | **GET** /game/{gameId}/solution | Gib die komplette Lösung des Labyrinths zurück |
| [**movePlayer**](DefaultApi.md#movePlayer) | **POST** /game/{gameId}/move | Führe einen Spielzug aus |
| [**resetGame**](DefaultApi.md#resetGame) | **POST** /game/{gameId}/reset | Setze das Spiel zurück |



## createGame

> GameDto createGame(createGameRequestDto)

Erstelle ein neues Labyrinth-Spiel

Startee ein neues Spiel mit dem Spieler auf Position A1 und dem Ziel auf E5

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        CreateGameRequestDto createGameRequestDto = new CreateGameRequestDto(); // CreateGameRequestDto | 
        try {
            GameDto result = apiInstance.createGame(createGameRequestDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createGame");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createGameRequestDto** | [**CreateGameRequestDto**](CreateGameRequestDto.md)|  | [optional] |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Labyrinth-Spiel erfolgreich erstellt |  -  |
| **500** | Serverfehler |  -  |


## createLabyrinth

> BoardDto createLabyrinth(gameId, createLabyrinthRequestDto)

Erstelle ein neues Labyrinth für das aktuelle Spiel

Generiere ein neues Labyrinth mit Wänden zwischen den Feldern

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        CreateLabyrinthRequestDto createLabyrinthRequestDto = new CreateLabyrinthRequestDto(); // CreateLabyrinthRequestDto | 
        try {
            BoardDto result = apiInstance.createLabyrinth(gameId, createLabyrinthRequestDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createLabyrinth");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |
| **createLabyrinthRequestDto** | [**CreateLabyrinthRequestDto**](CreateLabyrinthRequestDto.md)|  | [optional] |

### Return type

[**BoardDto**](BoardDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Labyrinth erfolgreich erstellt |  -  |
| **400** | Ungültige Labyrinth-Konfiguration |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


## getGameBoard

> BoardDto getGameBoard(gameId)

Gibe das aktuelle Labyrinth-Spielfeld zurück

Liefere Informationen über das Labyrinth einschließlich aller Wände, der Position des Spielers und des Ziels

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        try {
            BoardDto result = apiInstance.getGameBoard(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getGameBoard");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |

### Return type

[**BoardDto**](BoardDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Labyrinth erfolgreich zurückgegeben |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


## getGameStatus

> GameDto getGameStatus(gameId)

Gib den aktuellen Spielstatus zurück

Liefere Informationen über den aktuellen Zustand des Spiels

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        try {
            GameDto result = apiInstance.getGameStatus(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getGameStatus");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Spielstatus erfolgreich zurückgegeben |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


## getHint

> HintDto getHint(gameId)

Gib einen Hinweis zur Lösung des Labyrinths

Liefere einen Hinweis oder den nächsten Schritt auf dem Lösungsweg

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        try {
            HintDto result = apiInstance.getHint(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getHint");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |

### Return type

[**HintDto**](HintDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Hinweis erfolgreich zurückgegeben |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


## getSolution

> SolutionDto getSolution(gameId)

Gib die komplette Lösung des Labyrinths zurück

Liefere den vollständigen Lösungsweg von der aktuellen Position zum Ziel

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        try {
            SolutionDto result = apiInstance.getSolution(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getSolution");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |

### Return type

[**SolutionDto**](SolutionDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Lösung erfolgreich zurückgegeben |  -  |
| **404** | Spiel nicht gefunden oder keine Lösung möglich |  -  |
| **500** | Serverfehler |  -  |


## movePlayer

> MoveResponseDto movePlayer(gameId, moveRequestDto)

Führe einen Spielzug aus

Bewegt den Spieler in eine der vier möglichen Richtungen unter Berücksichtigung der Labyrinthwände

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        MoveRequestDto moveRequestDto = new MoveRequestDto(); // MoveRequestDto | 
        try {
            MoveResponseDto result = apiInstance.movePlayer(gameId, moveRequestDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#movePlayer");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |
| **moveRequestDto** | [**MoveRequestDto**](MoveRequestDto.md)|  | |

### Return type

[**MoveResponseDto**](MoveResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Bewegung erfolgreich durchgeführt oder verhindert durch Labyrinthwand |  -  |
| **400** | Ungültige Bewegungsrichtung |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


## resetGame

> GameDto resetGame(gameId)

Setze das Spiel zurück

Setzt den Spieler auf die Startposition A1 zurück, behält aber das Labyrinth bei

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        UUID gameId = UUID.randomUUID(); // UUID | ID des Spiels
        try {
            GameDto result = apiInstance.resetGame(gameId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#resetGame");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **gameId** | **UUID**| ID des Spiels | |

### Return type

[**GameDto**](GameDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Spiel erfolgreich zurückgesetzt |  -  |
| **404** | Spiel nicht gefunden |  -  |
| **500** | Serverfehler |  -  |


/*
 * Moderne Software Architekturen - 5x5-Labyrinth-API
 * API für das 5x5-Labyrinth-Spiel mit RESTful Endpunkten von Sebastian Wolf Mart.Nr 6771635
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.client.model.PositionDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * MoveResponseDto
 */
@JsonPropertyOrder({
  MoveResponseDto.JSON_PROPERTY_SUCCESS,
  MoveResponseDto.JSON_PROPERTY_NEW_POSITION,
  MoveResponseDto.JSON_PROPERTY_GAME_STATUS,
  MoveResponseDto.JSON_PROPERTY_WALL_HIT,
  MoveResponseDto.JSON_PROPERTY_MESSAGE
})
@JsonTypeName("MoveResponse")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-24T10:54:22.793437+02:00[Europe/Berlin]", comments = "Generator version: 7.10.0")
public class MoveResponseDto {
  public static final String JSON_PROPERTY_SUCCESS = "success";
  @jakarta.annotation.Nonnull
  private Boolean success;

  public static final String JSON_PROPERTY_NEW_POSITION = "newPosition";
  @jakarta.annotation.Nonnull
  private PositionDto newPosition;

  /**
   * Aktueller Status des Spiels nach der Bewegung
   */
  public enum GameStatusEnum {
    RUNNING(String.valueOf("running")),
    
    SUCCESS(String.valueOf("success")),
    
    FAILED(String.valueOf("failed"));

    private String value;

    GameStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GameStatusEnum fromValue(String value) {
      for (GameStatusEnum b : GameStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_GAME_STATUS = "gameStatus";
  @jakarta.annotation.Nonnull
  private GameStatusEnum gameStatus;

  public static final String JSON_PROPERTY_WALL_HIT = "wallHit";
  @jakarta.annotation.Nullable
  private Boolean wallHit;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @jakarta.annotation.Nullable
  private String message;

  public MoveResponseDto() {
  }

  public MoveResponseDto success(@jakarta.annotation.Nonnull Boolean success) {
    
    this.success = success;
    return this;
  }

  /**
   * Gibt an, ob die Bewegung erfolgreich war
   * @return success
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getSuccess() {
    return success;
  }


  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSuccess(@jakarta.annotation.Nonnull Boolean success) {
    this.success = success;
  }

  public MoveResponseDto newPosition(@jakarta.annotation.Nonnull PositionDto newPosition) {
    
    this.newPosition = newPosition;
    return this;
  }

  /**
   * Get newPosition
   * @return newPosition
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NEW_POSITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PositionDto getNewPosition() {
    return newPosition;
  }


  @JsonProperty(JSON_PROPERTY_NEW_POSITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNewPosition(@jakarta.annotation.Nonnull PositionDto newPosition) {
    this.newPosition = newPosition;
  }

  public MoveResponseDto gameStatus(@jakarta.annotation.Nonnull GameStatusEnum gameStatus) {
    
    this.gameStatus = gameStatus;
    return this;
  }

  /**
   * Aktueller Status des Spiels nach der Bewegung
   * @return gameStatus
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_GAME_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public GameStatusEnum getGameStatus() {
    return gameStatus;
  }


  @JsonProperty(JSON_PROPERTY_GAME_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGameStatus(@jakarta.annotation.Nonnull GameStatusEnum gameStatus) {
    this.gameStatus = gameStatus;
  }

  public MoveResponseDto wallHit(@jakarta.annotation.Nullable Boolean wallHit) {
    
    this.wallHit = wallHit;
    return this;
  }

  /**
   * Gibt an, ob der Spieler versucht hat, durch eine Wand zu gehen
   * @return wallHit
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_WALL_HIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getWallHit() {
    return wallHit;
  }


  @JsonProperty(JSON_PROPERTY_WALL_HIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWallHit(@jakarta.annotation.Nullable Boolean wallHit) {
    this.wallHit = wallHit;
  }

  public MoveResponseDto message(@jakarta.annotation.Nullable String message) {
    
    this.message = message;
    return this;
  }

  /**
   * Optionale Nachricht oder Rückmeldung zur Bewegung
   * @return message
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(@jakarta.annotation.Nullable String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveResponseDto moveResponse = (MoveResponseDto) o;
    return Objects.equals(this.success, moveResponse.success) &&
        Objects.equals(this.newPosition, moveResponse.newPosition) &&
        Objects.equals(this.gameStatus, moveResponse.gameStatus) &&
        Objects.equals(this.wallHit, moveResponse.wallHit) &&
        Objects.equals(this.message, moveResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, newPosition, gameStatus, wallHit, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveResponseDto {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    newPosition: ").append(toIndentedString(newPosition)).append("\n");
    sb.append("    gameStatus: ").append(toIndentedString(gameStatus)).append("\n");
    sb.append("    wallHit: ").append(toIndentedString(wallHit)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}




# MoveResponseDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**success** | **Boolean** | Gibt an, ob die Bewegung erfolgreich war |  |
|**newPosition** | [**PositionDto**](PositionDto.md) |  |  |
|**gameStatus** | [**GameStatusEnum**](#GameStatusEnum) | Aktueller Status des Spiels nach der Bewegung |  |
|**wallHit** | **Boolean** | Gibt an, ob der Spieler versucht hat, durch eine Wand zu gehen |  [optional] |
|**message** | **String** | Optionale Nachricht oder Rückmeldung zur Bewegung |  [optional] |



## Enum: GameStatusEnum

| Name | Value |
|---- | -----|
| RUNNING | &quot;running&quot; |
| SUCCESS | &quot;success&quot; |
| FAILED | &quot;failed&quot; |




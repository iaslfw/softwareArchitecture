

# CreateLabyrinthRequestDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Art des zu erstellenden Labyrinths |  [optional] |
|**difficulty** | [**DifficultyEnum**](#DifficultyEnum) | Schwierigkeitsgrad (bestimmt Anzahl der Wände) |  [optional] |
|**walls** | [**List&lt;WallDto&gt;**](WallDto.md) | Liste der benutzerdefinierten Wände (nur bei type&#x3D;predefined) |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| RANDOM | &quot;random&quot; |
| PREDEFINED | &quot;predefined&quot; |



## Enum: DifficultyEnum

| Name | Value |
|---- | -----|
| EASY | &quot;easy&quot; |
| MEDIUM | &quot;medium&quot; |
| HARD | &quot;hard&quot; |




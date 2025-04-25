

# GameDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Eindeutige ID des Spiels |  |
|**status** | [**StatusEnum**](#StatusEnum) | Aktueller Status des Spiels |  |
|**playerPosition** | [**PositionDto**](PositionDto.md) |  |  |
|**moves** | **Integer** | Anzahl der bisher durchgeführten Züge |  [optional] |
|**message** | **String** | Optionale Nachricht zum Spielstatus |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| RUNNING | &quot;running&quot; |
| SUCCESS | &quot;success&quot; |
| FAILED | &quot;failed&quot; |




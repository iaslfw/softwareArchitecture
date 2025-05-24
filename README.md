# 5x5 Mazegame

Erstellt von Sebastian Wolf. Mart.Nr: 6771635

### Curl Command zum testen

```
curl -X POST http://localhost:8080/game \
-H "Content-Type: application/json" \
-d '{"labyrinthType":"random","difficulty":"easy"}'
```

Um Schwierigkeit zu ändern, Parameter `difficulty` ändern.
Mögliche Paramter: `"easy" | "medium" | "hard"`


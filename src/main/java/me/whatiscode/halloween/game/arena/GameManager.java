package me.whatiscode.halloween.game.arena;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameManager {
    List<Game> AVAILABLE_GAMES = new ArrayList<>();

    public void addArena(Game game) {
        AVAILABLE_GAMES.add(game);
    }

    // Получаем все доступные арены, и проверяем, чтобы
    // они не были заполнены
    public Game getAvailableGame() {
        for (Game game : AVAILABLE_GAMES) {
            if (!game.isFull() && game.isAvailable()) {
                return game;
            }
        }
        // доступных арен нету
        return null;
    }
}

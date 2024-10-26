package me.whatiscode.halloween.game.arena;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Game {
    @NonFinal
    String name;
    @NonFinal
    Location spawn;
    @NonFinal
    int minPlayers;
    @NonFinal
    int maxPlayers;
    @NonFinal
    Set<Player> PLAYERS_HASH_SET = new HashSet<>();

    // Заполнена ли арена, чтобы избежать
    // бага с `лишними игроками`
    public boolean isFull() {
        return PLAYERS_HASH_SET.size() >= maxPlayers;
    }

    public boolean isAvailable() {
        return PLAYERS_HASH_SET.size() >= minPlayers;
    }

    public void addPlayer(Player player) {
        PLAYERS_HASH_SET.add(player);
    }

    public void removePlayer(Player player) {
        PLAYERS_HASH_SET.remove(player);
    }

    public void startGame() {
        // todo:: реализовать
    }

    public void endGame() {
        // todo:: реализовать

    }
}

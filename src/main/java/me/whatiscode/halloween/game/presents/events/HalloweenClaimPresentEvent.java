package me.whatiscode.halloween.game.presents.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.whatiscode.halloween.game.arena.list.HalloweenArenas;
import me.whatiscode.halloween.game.presents.HalloweenPresent;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HalloweenClaimPresentEvent extends Event {
    static HandlerList handlers = new HandlerList();
    Player player;
    HalloweenPresent present;
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

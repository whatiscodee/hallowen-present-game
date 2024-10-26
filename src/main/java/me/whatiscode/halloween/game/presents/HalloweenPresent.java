package me.whatiscode.halloween.game.presents;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;

@Getter
@RequiredArgsConstructor
public enum HalloweenPresent {
    GIFT_ONE("Gift_ONE", "texture", new Location(Bukkit.getWorld("world"), 1, 1, 1));

    private final String key;
    private final String texture;
    private final Location location;
}

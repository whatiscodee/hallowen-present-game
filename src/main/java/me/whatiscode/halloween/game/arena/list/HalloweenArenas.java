package me.whatiscode.halloween.game.arena.list;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;

@Getter
@RequiredArgsConstructor
public enum HalloweenArenas {
    TEST("Test", new Location(Bukkit.getWorld("world"), 1, 1, 1));

    private final String name;
    private final Location spawn;
}

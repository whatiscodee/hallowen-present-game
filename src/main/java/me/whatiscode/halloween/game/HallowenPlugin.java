package me.whatiscode.halloween.game;

import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author whatiscode (tg: @omgdurov)
 * <p>creation on 27.10.2024 at 0:00</p>
 */

@Getter
public class HallowenPlugin extends JavaPlugin {

    public static HallowenPlugin instance;

    @Override
    @SneakyThrows
    public void onEnable() {
        instance = this;
    }
}
package me.whatiscode.halloween.game.presents.listeners;

import lombok.val;
import me.whatiscode.halloween.game.presents.HalloweenPresent;
import me.whatiscode.halloween.game.sql.DatabaseUtil;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.sql.SQLException;

public class HalloweenPresentsListener implements Listener {

    static {
        DatabaseUtil.importDatabase();
    }

    @EventHandler
    public void onClickGift(PlayerInteractEvent event) throws SQLException {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        val block = event.getClickedBlock();

        if (block.getType() != Material.SKULL_ITEM) {
            return;
        }

        val skull = (Skull) block.getState();
        if (skull.getSkullType() != SkullType.PLAYER) {
            return;
        }

        val player = event.getPlayer();
        val giftLoc = block.getLocation();

        for (HalloweenPresent presents : HalloweenPresent.values()) {
            if (presents.getLocation().equals(giftLoc)) {

            }
        }
    }
}

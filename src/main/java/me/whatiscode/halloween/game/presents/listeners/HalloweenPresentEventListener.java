package me.whatiscode.halloween.game.presents.listeners;

import lombok.val;
import me.whatiscode.halloween.game.presents.HalloweenPresent;
import me.whatiscode.halloween.game.presents.events.HalloweenClaimPresentEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HalloweenPresentEventListener implements Listener {

    @EventHandler
    public void onClaimPresent(HalloweenClaimPresentEvent event) {
        val player = event.getPlayer();
        HalloweenPresent present = event.getPresent();

        /**
         * позже тут сделаем:
         * -> обновление борда
         * -> счетчик подарков
         * -> собраны ли подарки для конца игры
         */
    }
}

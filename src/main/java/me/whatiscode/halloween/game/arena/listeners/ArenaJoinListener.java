package me.whatiscode.halloween.game.arena.listeners;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import lombok.var;
import me.whatiscode.halloween.game.HallowenPlugin;
import me.whatiscode.halloween.game.arena.Game;
import me.whatiscode.halloween.game.arena.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArenaJoinListener implements Listener {
    GameManager gameManager;
    Map<Player, BukkitRunnable> TELEPORT_TASKS_MAP = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        val player = event.getPlayer();
        val game = gameManager.getAvailableGame();

        if (game == null) {
            player.sendMessage(ChatColor.RED + "Нет доступных арен. Пожалуйста, попробуйте позже.");
            return;
        }

        game.addPlayer(player);
        joinArenaMessage(game, player, true);
        giveHubItem(player);
    }

    private void joinArenaMessage(Game game, Player player, boolean isJoining) {
        var action = isJoining ? "подключился" : "отключился";
        var message = ChatColor.WHITE + "Игрок " + player.getName() + " " + action + " (" + game.getPLAYERS_HASH_SET().size() + "/" + game.getMaxPlayers() + ")";

        game.getPLAYERS_HASH_SET().forEach(p -> p.sendMessage(message));
    }

    private void giveHubItem(Player player) {
        val bed = new ItemStack(Material.BED);
        val meta = bed.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Вернуться в лобби");
        bed.setItemMeta(meta);

        player.getInventory().setItem(8, bed);

        HallowenPlugin.getInstance().getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onPlayerInteract(PlayerInteractEvent event) {
                if (!event.getPlayer().equals(player) || event.getItem() == null || event.getItem().getType() != Material.BED) return;

                val player = event.getPlayer();

                if (TELEPORT_TASKS_MAP.containsKey(player)) {
                    TELEPORT_TASKS_MAP.get(player).cancel();
                    TELEPORT_TASKS_MAP.remove(player);
                    player.sendMessage(ChatColor.RED + "Телепортация отменена.");
                } else {
                    player.sendMessage(ChatColor.YELLOW + "Телепортация в хаб через 5 секунд. Повторный клик отменит телепортацию.");

                    val task = new BukkitRunnable() {

                        @Override
                        public void run() {
                            player.performCommand("hub");
                            TELEPORT_TASKS_MAP.remove(player);
                        }
                    };

                    task.runTaskLater(HallowenPlugin.getInstance(), 100);
                    TELEPORT_TASKS_MAP.put(player, task);
                }
                event.setCancelled(true);
            }
        }, HallowenPlugin.getInstance());
    }
}

package uk.tellowharton.mc.brandon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Iterator;

/**
 * Created by Aaron on 27/02/2016.
 */
public class MyListener implements Listener {

    private final Congrats congrats;

    public MyListener(Congrats congrats) {
        this.congrats = congrats;
    }

    @EventHandler
    public void onAchievement(final PlayerAchievementAwardedEvent e){

        final Player player = e.getPlayer();
        if(player.getName().equalsIgnoreCase(congrats.getBrandon())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("Server to Brandon: congrats");
                    final Iterator<? extends Player> playerIterator = Bukkit.getOnlinePlayers().iterator();
                    int tick = 20;
                    while (playerIterator.hasNext()){
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                playerIterator.next().chat("congrats");
                                player.getInventory().addItem(new ItemStack(Material.FURNACE,1));
                            }
                        }.runTaskLater(congrats,tick);
                        tick+= 20;
                    }
                }
            }.runTaskLater(congrats, 60);
        }
    }
}

package uk.tellowharton.mc.brandon;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

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

        Player p = e.getPlayer();
        if(p.getName().equalsIgnoreCase(congrats.getBrandon())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("Server to Brandon: congrats");
                }
            }.runTaskLater(congrats, 60);
        }
    }
}

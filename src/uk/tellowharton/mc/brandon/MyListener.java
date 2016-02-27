package uk.tellowharton.mc.brandon;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

/**
 * Created by Aaron on 27/02/2016.
 */
public class MyListener implements Listener {

    private final Congrats congrats;

    public MyListener(Congrats congrats) {
        this.congrats = congrats;
    }

    @EventHandler
    public void onAchievement(PlayerAchievementAwardedEvent e){
        Player p = e.getPlayer();
        if(p.getName().equals(congrats.getBrandon())){
            Bukkit.broadcastMessage("congrats");
        }
    }
}

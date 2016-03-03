package uk.tellowharton.mc.brandon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
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

                    Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                    final Iterator<? extends Player> playerIterator = onlinePlayers.iterator();

                    final int level = onlinePlayers.size();
                    int tick = 20;
                    while (playerIterator.hasNext()){
                        final Player p;
                        if (!(p = playerIterator.next()).getName().equalsIgnoreCase(congrats.getBrandon())) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    p.chat("congrats");
                                    ItemStack is = new ItemStack(Material.FURNACE, 1);
                                    ItemMeta im = is.getItemMeta();
                                    im.addEnchant(new Enchantment(level) {
                                        @Override
                                        public String getName() {
                                            return "congrats";
                                        }

                                        @Override
                                        public int getMaxLevel() {
                                            return level;
                                        }

                                        @Override
                                        public int getStartLevel() {
                                            return level;
                                        }

                                        @Override
                                        public EnchantmentTarget getItemTarget() {
                                            return null;
                                        }

                                        @Override
                                        public boolean conflictsWith(Enchantment enchantment) {
                                            return false;
                                        }

                                        @Override
                                        public boolean canEnchantItem(ItemStack itemStack) {
                                            return false;
                                        }
                                    },level,true);
                                    player.getInventory().addItem();
                                }
                            }.runTaskLater(congrats, tick);
                            tick += 20;
                        }
                    }
                }
            }.runTaskLater(congrats, 60);
        }
    }
}

package uk.tellowharton.mc.brandon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Aaron on 27/02/2016.
 */
public class Congrats extends JavaPlugin {

    private String brandon;

    @Override
    public void onEnable(){
        this.saveDefaultConfig();
        brandon = getConfig().getString("brandon");
        getServer().getPluginManager().registerEvents(new MyListener(this), this);
    }

    public String getBrandon(){
        return brandon;
    }
}

package me.xBuhari.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class DBUtils {
    protected static JavaPlugin plugin;

    public final Utils utils;

    public DBUtils(JavaPlugin plugin) {
        DBUtils.plugin = plugin;
        this.utils = new Utils();
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}

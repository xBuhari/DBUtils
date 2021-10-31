package me.xBuhari.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DB {

    public FileConfiguration fileConf;
    private File file;

    public DB(String path) {
        this.file = new File(DBUtils.plugin.getDataFolder() + "" + path);
        if (!this.file.exists()) {
            this.file = new File(getClass().getResource(path).getFile());
        }
        this.fileConf = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            this.fileConf.save(this.file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void reload() {
        if (!this.file.exists()) {
            this.file = new File(getClass().getResource(file.getPath()).getFile());
        }
        this.fileConf = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }
}

package br.com.liofly;

import br.com.liofly.comandos.Fly;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§a§l[LioFly]§a Plugin ligado com sucesso!");
        instance = this;

        getCommand("fly").setExecutor(new Fly());
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c§l[LioFly]§c Plugin desligado com sucesso!");

    }

    public static Main getInstance() {
        return instance;

    }

}
package br.com.liofly.comandos;

import br.com.liofly.Main;
import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {

        if (Sender instanceof Player) {
            Player p = (Player) Sender;
            String th = Main.getInstance().getConfig().getString("title-fly-habilitar.title-fly-habilitar");
            String sh = Main.getInstance().getConfig().getString("title-fly-habilitar.subtitle-fly-habilitar");
            String td = Main.getInstance().getConfig().getString("title-fly-desabilitar.title-fly-desabilitar");
            String sd = Main.getInstance().getConfig().getString("title-fly-desabilitar.subtitle-fly-desabilitar");
            boolean titleh = Main.getInstance().getConfig().getBoolean("title-fly-habilitar.ativar");
            boolean titled = Main.getInstance().getConfig().getBoolean("title-fly-desabilitar.ativar");

            if (p.hasPermission("fly.usar")) {

                if (p.getAllowFlight() == true) {
                    p.setAllowFlight(false);
                    p.sendMessage(Main.getInstance().getConfig().getString("fly-desabilitar").replace("&", "§"));
                if (titled == true) {
                    TitleAPI.sendTitle(p, 10, 40, 10, td, sd);
                }

                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(Main.getInstance().getConfig().getString("fly-habilitar").replace("&", "§"));
                if (titleh == true) {
                    TitleAPI.sendTitle(p, 10, 40, 10, th, sh);
                }

                }

            } else {
                p.sendMessage(Main.getInstance().getConfig().getString("sem-permissão").replace("&", "§"));
            }

        } else {
            Bukkit.getConsoleSender().sendMessage(Main.getInstance().getConfig().getString("console-não-pode").replace("&", "§"));
        }
        return false;
    }
}
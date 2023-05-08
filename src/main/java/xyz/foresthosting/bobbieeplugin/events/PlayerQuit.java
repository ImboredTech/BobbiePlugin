package xyz.foresthosting.bobbieeplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.foresthosting.bobbieeplugin.BobbieePlugin;

public class PlayerQuit implements Listener
{
    private final BobbieePlugin plugin;
    public PlayerQuit(BobbieePlugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String quitMessage = plugin.getConfig().getString("quitMessage");
        event.setQuitMessage(ChatColor.RED + quitMessage.replace("%player", player.getName()));
    }
}

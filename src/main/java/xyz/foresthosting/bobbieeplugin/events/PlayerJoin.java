package xyz.foresthosting.bobbieeplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.foresthosting.bobbieeplugin.BobbieePlugin;

public class PlayerJoin implements Listener
{
    private final BobbieePlugin plugin;
    public PlayerJoin(BobbieePlugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore())
        {
            String hasnotplayedbefore = plugin.getConfig().getString("notplayedbefore");
            event.setJoinMessage(ChatColor.GREEN + hasnotplayedbefore.replace("%player", player.getName()));
        } else if(player.hasPlayedBefore())
        {
            String hasplayedbefore = plugin.getConfig().getString("hasplayedbefore");
            event.setJoinMessage(ChatColor.GREEN + hasplayedbefore.replace("%player", player.getName()));
        }
    }
}

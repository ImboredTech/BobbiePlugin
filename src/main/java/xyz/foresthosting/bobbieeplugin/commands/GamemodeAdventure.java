package xyz.foresthosting.bobbieeplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.foresthosting.bobbieeplugin.BobbieePlugin;

public class GamemodeAdventure implements CommandExecutor
{
    private final BobbieePlugin plugin;
    public GamemodeAdventure(BobbieePlugin plugin)
    {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // checking to see if the sender is a player
        if(sender instanceof Player)
        {
            // checking to see if the player has permission.
            if(sender.hasPermission("bobbieplugin.adventure") || sender.hasPermission("bobbieplugin.gamemode"))
            {
                // checking to see if they specified a player
                if(args.length < 1)
                {
                    ((Player) sender).setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure.");
                }
                // applying logic when they specify a player.
                else if(args.length > 1)
                {
                    Player player = Bukkit.getPlayer(args[0]);
                    // checking to see if the player exists ingame.
                    if(player == null)
                    {
                        sender.sendMessage(ChatColor.RED + "Player not online!");
                    }
                    // applying logic if they do
                    else
                    {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure.");
                        sender.sendMessage(ChatColor.GREEN + "The player's gamemode has been changed to adventure.");
                    }
                }
            }
            // applying logic when they don't have permission.
            else
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
            }
        }
        // applying logic when they aren't a player.
        else
        {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You must be ingame to run this command.");
        }
        return false;
    }
}

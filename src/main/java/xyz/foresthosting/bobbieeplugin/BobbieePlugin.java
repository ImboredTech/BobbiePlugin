package xyz.foresthosting.bobbieeplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.foresthosting.bobbieeplugin.commands.GamemodeAdventure;
import xyz.foresthosting.bobbieeplugin.commands.GamemodeCreative;
import xyz.foresthosting.bobbieeplugin.commands.GamemodeSpectator;
import xyz.foresthosting.bobbieeplugin.commands.GamemodeSurvival;
import xyz.foresthosting.bobbieeplugin.events.PlayerJoin;
import xyz.foresthosting.bobbieeplugin.events.PlayerQuit;

public final class BobbieePlugin extends JavaPlugin
{

    // Plugin startup logic
    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        loadCommands();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Started BobbiePlugin and all its commands and events.");
    }

    // Plugin shutdown Logic
    @Override
    public void onDisable()
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Disabling BobbiePlugin...");
    }

    // Loads all commands
    public void loadCommands()
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Loading Commands...");
        getCommand("gmc").setExecutor(new GamemodeCreative(this));
        getCommand("gms").setExecutor(new GamemodeSurvival(this));
        getCommand("gmsp").setExecutor(new GamemodeSpectator(this));
        getCommand("gma").setExecutor(new GamemodeAdventure(this));
    }

    // Loads all events
    public void loadEvents()
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Loading Events...");
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);
    }
}
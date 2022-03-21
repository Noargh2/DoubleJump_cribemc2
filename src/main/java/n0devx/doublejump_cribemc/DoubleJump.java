package n0devx.doublejump_cribemc;

import org.bukkit.plugin.java.JavaPlugin;

import n0devx.doublejump_cribemc.listeners.DoubleJumpListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoubleJump extends JavaPlugin {
    public DoubleJump() {
    }

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new DoubleJumpListeners(), this);
    }
}

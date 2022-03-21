package n0devx.doublejump_cribemc.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.HashMap;

public class DoubleJumpListeners implements Listener {

    private HashMap <Player, Boolean> cooldown = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().setAllowFlight(true);
        cooldown.put(event.getPlayer() , false);

    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent event){
        if (event.getPlayer().getGameMode() == GameMode.SURVIVAL || event.getPlayer().getGameMode() == GameMode.ADVENTURE) {
            event.setCancelled(true);
            if (cooldown.get(event.getPlayer())) return;
            event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().setY(1));
            cooldown.put(event.getPlayer() , true);
        }
    }
//check if on ground
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(event.getPlayer().isOnGround()){
            cooldown.put(event.getPlayer() , false);
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event){
        if (event.getNewGameMode() == GameMode.SURVIVAL || event.getNewGameMode() == GameMode.ADVENTURE){
            event.getPlayer().setAllowFlight(true);

        }
    }
}

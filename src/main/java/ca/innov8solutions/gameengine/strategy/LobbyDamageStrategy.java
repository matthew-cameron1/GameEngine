package ca.innov8solutions.gameengine.strategy;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class LobbyDamageStrategy implements DamageStrategy {

    @Override
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }
}

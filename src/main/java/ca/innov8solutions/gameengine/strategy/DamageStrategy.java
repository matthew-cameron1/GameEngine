package ca.innov8solutions.gameengine.strategy;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public interface DamageStrategy extends GameStrategy {

    void onDamage(EntityDamageEvent e);
    void onDamageByEntity(EntityDamageByEntityEvent e);
}

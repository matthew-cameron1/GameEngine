package ca.innov8solutions.gameengine.strategy;


import ca.innov8solutions.gameengine.player.EnginePlayer;
import ca.innov8solutions.gameengine.team.Team;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamedDamageStrategy<E extends EnginePlayer> implements DamageStrategy {

    private @Autowired TeamStrategy<E> teamStrategy;
    private @Autowired ConnectionStrategy<E> connectionStrategy;

    @Override
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player pl = (Player) e.getEntity();

            Team playerTeam = teamStrategy.getPlayerTeam(connectionStrategy.getConnectedPlayer(pl.getUniqueId()));

            if (playerTeam == null)
                return;
        }
    }

    @Override
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player killer = (Player) e.getDamager();
            Player victim = (Player) e.getEntity();

            Team t = teamStrategy.getPlayerTeam(connectionStrategy.getConnectedPlayer(killer.getUniqueId()));
            Team t2 = teamStrategy.getPlayerTeam(connectionStrategy.getConnectedPlayer(victim.getUniqueId()));

            if (!teamStrategy.canTakeDamage(t2, t)) {
                e.setCancelled(true);
                e.setDamage(0);
                return;
            }
        }
        else if (e.getDamager() instanceof Projectile && ((Projectile) e.getDamager()).getShooter() instanceof Player && e.getEntity() instanceof Player) {
            Player killer = (Player) ((Projectile) e.getDamager()).getShooter();
            Player victim = (Player) e.getEntity();
            Team t = teamStrategy.getPlayerTeam(connectionStrategy.getConnectedPlayer(killer.getUniqueId()));
            Team t2 = teamStrategy.getPlayerTeam(connectionStrategy.getConnectedPlayer(victim.getUniqueId()));

            if (!teamStrategy.canTakeDamage(t2, t)) {
                e.setCancelled(true);
                e.setDamage(0);
                return;
            }
        }
    }
}

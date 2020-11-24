package ca.innov8solutions.gameengine.strategy;

import ca.innov8solutions.gameengine.player.EnginePlayer;
import ca.innov8solutions.gameengine.team.Team;
import org.bukkit.Location;

import java.util.List;

public class TeamStrategy<E extends EnginePlayer> implements GameStrategy {

    private List<Team> teams;

    public void joinTeam(String name, E e) {
        Team<E> team = getTeamByName(name);
        team.getTeamMembers().add(e);

        e.sendMessage("You joined team " + team.getName());
    }

    public Team<E> getTeamByName(String name) {
        return teams.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Team<E> getPlayerTeam(E e) {
        for (Team t : teams) {
            if (t.getTeamMembers().contains(e)) {
                return t;
            }
        }
        return null;
    }

    boolean canTakeDamage(Team damaged, Team damager) {
        if (!damaged.isDamageable()) {
            return false;
        }

        if (damaged.getName().equalsIgnoreCase(damager.getName())) {
            return damaged.isFriendlyFire();
        }
        return true;
    }

    public void spawnTeam(Team<E> t, Location spawn) {
        t.getTeamMembers().forEach(mem -> {
            mem.teleport(spawn);
        });
    }
    public void addTeam(Team<E> team) {
        this.teams.add(team);
    }
}

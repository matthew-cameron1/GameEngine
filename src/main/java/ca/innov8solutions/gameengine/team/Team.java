package ca.innov8solutions.gameengine.team;

import ca.innov8solutions.gameengine.player.EnginePlayer;

import java.util.ArrayList;
import java.util.List;

public class Team<E extends EnginePlayer> {

    private String name;
    private List<E> teamMembers;

    private boolean damageable = true;
    private boolean friendlyFire = false;

    public Team(String name) {
        this.name = name;
        this.teamMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<E> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<E> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public boolean isDamageable() {
        return damageable;
    }

    public void setDamageable(boolean damageable) {
        this.damageable = damageable;
    }

    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }
}

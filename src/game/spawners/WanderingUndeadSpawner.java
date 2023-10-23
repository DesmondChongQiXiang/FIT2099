package game.spawners;

import game.actors.enemies.WanderingUndead;

public class WanderingUndeadSpawner implements Spawner{
    /**
     * Spawner for generating instances of the Wandering Undead.
     */
    @Override
    public WanderingUndead spawn() {
        return new WanderingUndead();
    }
}

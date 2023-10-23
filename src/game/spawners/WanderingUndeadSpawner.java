package game.spawners;

import game.actors.enemies.WanderingUndead;

/**
 * Spawner for generating instances of the Wandering Undead.
 */
public class WanderingUndeadSpawner extends Spawner{
    /**
     * Spawner for generating instances of the Wandering Undead.
     */

    public WanderingUndeadSpawner(){
        super(25);
    }
    @Override
    public WanderingUndead createEnemy() {
        return new WanderingUndead();
    }
}

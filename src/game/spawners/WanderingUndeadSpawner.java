package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.WanderingUndead;

/**
 * A spawner for generating instances of the Wandering Undead enemy actor.
 * This class implements the Spawner interface and is responsible for spawning Wandering Undead actors in the game world.
 *
 * The spawner is capable of randomly spawning Wandering Undead actors at specified locations in the game world based on predefined criteria.
 *
 * @see Spawner
 * @see Enemy
 * @see WanderingUndead
 *
 * @author MA_AppliedSession1_Group7
 */
public class WanderingUndeadSpawner implements Spawner{
    /**
     * Spawns an instance of the WanderingUndead enemy actor at the specified location within the game world, if the spawn conditions are met.
     *
     * @param location The location at which the enemy actor should be spawned.
     * @return a Wandering Undead that has been spawned.
     */
    public Enemy spawn(Location location){
        if (Math.random() <= ((double) 25 / 100) && !location.containsAnActor()) {
            Enemy wanderingUndead = new WanderingUndead();
            location.addActor(wanderingUndead);
            return wanderingUndead;
        }
        return null;
    };
}

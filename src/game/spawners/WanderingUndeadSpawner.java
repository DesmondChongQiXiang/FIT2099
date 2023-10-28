package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.WanderingUndead;
import java.util.ArrayList;

/**
 * A spawner for generating instances of the Wandering Undead enemy actor.
 * This class implements the Spawner interface and is responsible for spawning Wandering Undead actors in the game world.
 *
 * The spawner is capable of randomly spawning Wandering Undead actors at specified locations in the game world based on predefined criteria.
 * It tracks the spawned enemy actors for later operations such as resetting.
 *
 * @see Spawner
 * @see Enemy
 * @see WanderingUndead
 *
 * @author MA_AppliedSession1_Group7
 */
public class WanderingUndeadSpawner extends Spawner{
    /**
     * Constructor to create a WanderingUndeadSpawner instance.
     * Initializes the list for tracking spawned enemy actors.
     */
    public WanderingUndeadSpawner() {
        super(25);
    }

    @Override
    public WanderingUndead createEnemy() {
        return new WanderingUndead();
    }
}

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
public class WanderingUndeadSpawner implements Spawner{
    protected ArrayList<Enemy> enemyList;

    /**
     * Constructor to create a WanderingUndeadSpawner instance.
     * Initializes the list for tracking spawned enemy actors.
     */
    public WanderingUndeadSpawner() {
        this.enemyList = new ArrayList<>();
    }

    /**
     * Spawns a Wandering Undead enemy actor at the specified location based on random chance.
     *
     * @param location The location at which the Wandering Undead actor should be spawned.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 25 / 100) && !location.containsAnActor()) {
            Enemy enemy = new WanderingUndead();
            location.addActor(enemy);
            enemyList.add(enemy);
        }
    }

    /**
     * Resets the state of spawned Wandering Undead actors at the specified location.
     *
     * @param location The location where enemy actors should be reset.
     */
    @Override
    public void reset(Location location) {
        for (Enemy enemy : enemyList){
            enemy.reset(location);
        }
    }
}

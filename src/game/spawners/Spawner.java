package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Represent a spawner of an enemy
 */
public interface Spawner {
    /**
     * @param location the location of spawn the enemy
     */
    void spawn(Location location);
}

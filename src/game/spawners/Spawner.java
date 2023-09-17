package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * The Spawner interface defines a contract for classes that are responsible for spawning actors at specific locations
 * within a game map.
 *
 * Implementing classes must provide an implementation for the {@link #spawn(Location)} method, which specifies how
 * actors are created and placed in the game world.
 *
 * @author Ong Chong How
 *
 * @see edu.monash.fit2099.engine.positions.Location
 *
 * @version 1.0
 */
public interface Spawner {

    /**
     * Spawns actors at a specified location within the game map.
     *
     * Implementing classes are responsible for defining the logic to create actors and place them at the given
     * location within the game world.
     *
     * @param location The location within the game map where the actors should be spawned.
     */
    void spawn(Location location);
}

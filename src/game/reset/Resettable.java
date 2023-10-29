package game.reset;

import edu.monash.fit2099.engine.positions.Location;

/**
 * The `Resettable` interface is implemented by entities that can be reset to their initial state
 * at a specific location in the game world.
 */
public interface Resettable {

    /**
     * Resets the implementing entity to its initial state at the specified location.
     *
     * @param location The location where the entity should be reset.
     */
    void reset(Location location);
}

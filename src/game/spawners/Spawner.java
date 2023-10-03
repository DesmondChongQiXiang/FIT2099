package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 */
public interface Spawner {

  /**
   * Spawns an enemy actor at the specified location.
   *
   * @param location The location where the enemy actor is to be spawned.
   */
  void spawn(Location location);


}

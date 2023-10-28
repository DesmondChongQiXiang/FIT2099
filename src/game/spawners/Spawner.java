package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 *
 * Implementations of this interface handle the creation and placement of enemy actors at predefined locations in the game world.
 * The specific criteria for spawning an enemy actor may vary depending on the implementing class.
 *
 * @see Resettable
 *
 * @author MA_AppliedSession1_Group7
 */
public interface Spawner extends Resettable {
  /**
   * Spawns an enemy actor at the specified location.
   *
   * @param location The location at which the enemy actor should be spawned.
   */
  void spawn(Location location);
}


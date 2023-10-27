package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 *
 * @author MA_AppliedSession1_Group7
 */
public interface Spawner extends Resettable {
  /**
   * Spawns an enemy actor at the specified location.
   */
  void spawn(Location location);
}

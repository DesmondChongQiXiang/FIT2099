package game.spawners;


import game.actors.enemies.Enemy;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 */
public interface Spawner {

  /**
   * Spawns an enemy actor at the specified location.
   */
  Enemy spawn();


}

package game.spawners.forestenemyspawner;

import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.RedWolf;

/**
 * A spawner class responsible for spawning the Red Wolf enemy in the game world.
 * The Red Wolf has a 30% chance of spawning at the specified location if it does not already contain an actor.
 */
public class RedWolfSpawner implements ForestEnemySpawner {

  /**
   * Spawn the Red Wolf enemy at the specified location if conditions are met.
   */
  @Override
  public Enemy spawn(){
    return new RedWolf();
  }

  @Override
  public void sunnyMode() {
    
  }

  @Override
  public void rainyMode() {

  }
}

package game.spawners.forestenemyspawner;


import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.ForestKeeper;

/**
 * A spawner class responsible for spawning the Forest Keeper enemy in the game world.
 * The Forest Keeper has a 15% chance of spawning at the specified location if it does not already contain an actor.
 */
public class ForestKeeperSpawner implements ForestEnemySpawner {

  /**
   * Spawn the Forest Keeper enemy at the specified location if conditions are met.
   */
  @Override
  public Enemy spawn(){
    return new ForestKeeper();
  }

  @Override
  public void sunnyMode() {
  }

  @Override
  public void rainyMode() {
  }
}

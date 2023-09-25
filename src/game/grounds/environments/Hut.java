package game.grounds.environments;

import game.spawners.ForestKeeperSpawner;

/**
 * Represents a type of ground called "Hut" that can spawn enemies.
 */
public class Hut extends EnemySpawnableGround{

  /**
   * Constructor.
   */
  public Hut(){
    super('h', new ForestKeeperSpawner());
  }


}

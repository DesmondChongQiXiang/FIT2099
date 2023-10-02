package game.grounds.environments;

import game.spawners.ForestKeeperSpawner;

public class Hut extends EnemySpawnableGround{

  /**
   * Constructor.
   */
  public Hut(){
    super('h', new ForestKeeperSpawner());
  }


}

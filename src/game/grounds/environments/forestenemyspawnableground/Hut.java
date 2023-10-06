package game.grounds.environments.forestenemyspawnableground;

import game.actors.enemies.forestenemy.ForestKeeper;
import game.spawners.forestenemyspawner.ForestKeeperSpawner;

public class Hut extends ForestEnemySpawnableGround {

  /**
   * Constructor.
   */
  public Hut(ForestKeeperSpawner forestKeeperSpawner){
    super('h', 15,forestKeeperSpawner);
  }


}

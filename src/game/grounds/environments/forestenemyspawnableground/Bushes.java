package game.grounds.environments.forestenemyspawnableground;

import game.spawners.forestenemyspawner.RedWolfSpawner;

public class Bushes extends ForestEnemySpawnableGround {

  /**
   * Constructor.
   */
  public Bushes(RedWolfSpawner redWolfSpawner){
    super('m', 30,redWolfSpawner);
  }
}

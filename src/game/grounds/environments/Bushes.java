package game.grounds.environments;

import game.spawners.RedWolfSpawner;

public class Bushes extends EnemySpawnableGround{

  /**
   * Constructor.
   */
  public Bushes(){
    super('m', new RedWolfSpawner());
  }


}

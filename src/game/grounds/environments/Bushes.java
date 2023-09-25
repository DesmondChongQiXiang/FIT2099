package game.grounds.environments;

import game.spawners.RedWolfSpawner;

/**
 * Represents a type of ground called "Bushes" that can spawn enemies.
 */
public class Bushes extends EnemySpawnableGround{

  /**
   * Constructor.
   */
  public Bushes(){
    super('m', new RedWolfSpawner());
  }


}

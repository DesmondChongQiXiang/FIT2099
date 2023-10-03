package game.grounds.environments;

import game.spawners.RedWolfSpawner;

/**
 * The `Bushes` class represents a type of ground environment where Red Wolves can spawn.
 * It extends the `EnemySpawnableGround` class and specifies the ground symbol as 'm' and uses the `RedWolfSpawner` to spawn Red Wolves.
 */
public class Bushes extends EnemySpawnableGround{

  /**
   * Constructs a new instance of the `Bushes` class.
   * Sets the ground symbol to 'm' and initializes it with a `RedWolfSpawner` to allow the spawning of Red Wolves.
   */
  public Bushes(){
    super('m', new RedWolfSpawner());
  }


}

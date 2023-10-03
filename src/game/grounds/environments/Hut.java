package game.grounds.environments;

import game.spawners.ForestKeeperSpawner;

/**
 * The `Hut` class represents a specific type of ground environment, which is a hut. Huts allow the spawning of forest keepers over time.
 * It extends the `EnemySpawnableGround` class and is associated with a specific `ForestKeeperSpawner` for spawning forest keepers.
 */
public class Hut extends EnemySpawnableGround{

  /**
   * Constructor to create a `Hut` instance.
   */
  public Hut(){
    super('h', new ForestKeeperSpawner());
  }

}

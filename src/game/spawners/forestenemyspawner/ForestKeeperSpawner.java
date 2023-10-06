package game.spawners.forestenemyspawner;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.spawners.Spawner;

public class ForestKeeperSpawner implements ForestEnemySpawner {

  /**
   * Spawn the Forest Keeper enemy
   */
  @Override
  public ForestKeeper spawn(){
    return new ForestKeeper();
  }
}

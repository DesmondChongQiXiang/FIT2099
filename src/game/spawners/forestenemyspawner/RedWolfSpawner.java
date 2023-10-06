package game.spawners.forestenemyspawner;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.forestenemy.RedWolf;
import game.spawners.Spawner;

public class RedWolfSpawner implements ForestEnemySpawner {

  /**
   * Spawn the Red Wolf enemy
   */
  @Override
  public RedWolf spawn(){
    return new RedWolf();
  }


}

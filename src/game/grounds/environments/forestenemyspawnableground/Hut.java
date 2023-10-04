package game.grounds.environments.forestenemyspawnableground;

import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.spawners.forestenemyspawner.ForestEnemySpawner;
import game.spawners.forestenemyspawner.ForestKeeperSpawner;

public class Hut extends ForestEnemySpawnableGround {

  /**
   * Constructor.
   */
  public Hut(ForestEnemySpawner forestKeeperSpawner){
    super('h', 15,forestKeeperSpawner);
  }

  @Override
  public void sunnyMode(){
    super.setSpawnRate(30);
    for (Enemy enemy : forestEnemyList){
      enemy.sunnyMode();
    }
  }

  @Override
  public void rainyMode(){
    super.setSpawnRate(15);
    for (Enemy enemy : forestEnemyList){
      enemy.rainyMode();
    }
  }
}

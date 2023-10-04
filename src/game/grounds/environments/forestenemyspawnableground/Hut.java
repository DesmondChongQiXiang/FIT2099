package game.grounds.environments.forestenemyspawnableground;

import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.actors.enemies.forestenemy.RedWolf;
import game.actors.enemies.villageenemy.HollowSoldier;
import game.spawners.Spawner;

public class Hut<F extends ForestKeeper> extends ForestEnemySpawnableGround<F> {

  /**
   * Constructor.
   */
  public Hut(Spawner<F> forestKeeperSpawner){
    super('h', 15,forestKeeperSpawner);
  }

  @Override
  public void sunnyMode() {
    super.setSpawnRate(30);
    for(ForestEnemy forestEnemy: forestEnemyList){
      forestEnemy.sunnyMode();
    }
  }

  @Override
  public void rainyMode() {
    super.setSpawnRate(15);
    for(ForestEnemy forestEnemy: forestEnemyList){
      forestEnemy.rainyMode();
    }
  }
}

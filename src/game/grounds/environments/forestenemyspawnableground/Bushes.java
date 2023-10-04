package game.grounds.environments.forestenemyspawnableground;

import game.actors.enemies.Enemy;
import game.spawners.forestenemyspawner.ForestEnemySpawner;
import game.spawners.forestenemyspawner.RedWolfSpawner;

public class Bushes extends ForestEnemySpawnableGround {

  /**
   * Constructor.
   */
  public Bushes(ForestEnemySpawner redWolfSpawner) {
    super('m', 30, redWolfSpawner);
  }

  @Override
  public void sunnyMode() {
    super.setSpawnRate(30);
    for (Enemy enemy : forestEnemyList){
      enemy.sunnyMode();
    }
  }

  @Override
  public void rainyMode() {
    super.setSpawnRate(45);
    for (Enemy enemy : forestEnemyList){
      enemy.rainyMode();
    }
  }
}

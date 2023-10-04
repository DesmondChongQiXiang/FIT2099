package game.grounds.environments.forestenemyspawnableground;

import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.forestenemy.RedWolf;
import game.spawners.Spawner;
import game.weathers.WeatherControl;
import game.weathers.WeatherControllable;

public class Bushes<R extends RedWolf> extends ForestEnemySpawnableGround<R> {

  /**
   * Constructor.
   */
  public Bushes(Spawner<R> redWolfSpawner){
    super('m', 30,redWolfSpawner);
  }

  @Override
  public void sunnyMode() {
    super.setSpawnRate(30);
    for(WeatherControllable forestEnemy:forestEnemyList){
      forestEnemy.sunnyMode();
    }
  }

  @Override
  public void rainyMode() {
    super.setSpawnRate(45);
    for(WeatherControllable forestEnemy:forestEnemyList){
      forestEnemy.rainyMode();
    }
  }
}

package game.grounds.environments.forestenemyspawnableground;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.enemies.forestenemy.RedWolf;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

public class Bushes<R extends RedWolf> extends ForestEnemySpawnableGround<R> {

  /**
   * Constructor.
   */
  public Bushes(Spawner<R> redWolfSpawner){
    super('m', 30,redWolfSpawner);
  }

  @Override
  public void updateWeatherMode(Weather weather, Display display) {
    if (weather == Weather.SUNNY){
      super.setSpawnRate(30);
      display.println("The red wolves are becoming less active.");
    }
    else if (weather == Weather.RAINY){
      super.setSpawnRate(45);
      display.println("The red wolves are becoming more active.");
    }
    for(WeatherControllable forestEnemy: forestEnemyList){
      forestEnemy.updateWeatherMode(weather,display);
    }
  }
}

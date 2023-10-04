package game.grounds.environments.forestenemyspawnableground;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

public class Hut<F extends ForestKeeper> extends ForestEnemySpawnableGround<F> {

  /**
   * Constructor.
   */
  public Hut(Spawner<F> forestKeeperSpawner){
    super('h', 15,forestKeeperSpawner);
  }

  @Override
  public void updateWeatherMode(Weather weather, Display display) {
    if(weather == Weather.SUNNY){
      super.setSpawnRate(30);
      display.println("The forest keepers are becoming more active.");
    }
    else if(weather == Weather.RAINY){
      super.setSpawnRate(15);
      display.println("The forest keepers are becoming less active.");
    }
    for(WeatherControllable forestEnemy: forestEnemyList){
      forestEnemy.updateWeatherMode(weather,display);
    }
  }
}

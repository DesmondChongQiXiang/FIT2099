package game.grounds.environments.forestenemyground;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

/**
 * The Hut class represents a type of ground in the forest environment where Forest Keepers can spawn.
 * It extends the ForestEnemySpawnableGround class and provides functionality to control the spawning of Forest Keepers based on weather conditions.
 *
 * This class sets the specific character representation and spawn rate for Forest Keepers spawning in huts.
 * The spawning rate can vary depending on the weather conditions in the game.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <F> The type of Forest Keeper enemy that can spawn in this type of ground.
 * @see ForestEnemySpawnableGround
 * @see WeatherControllable
 */
public class Hut<F extends ForestKeeper> extends ForestEnemySpawnableGround<F> {

  /**
   * Constructor to create a Hut instance.
   *
   * @param forestKeeperSpawner The spawner for Forest Keepers associated with this type of ground.
   */
  public Hut(Spawner<F> forestKeeperSpawner){
    super('h', 15, forestKeeperSpawner);
  }

  /**
   * Updates the spawn rate and behavior of Forest Keepers based on the current weather conditions.
   *
   * @param weather The current weather in the game.
   * @param display The display interface used to print messages about weather-related changes.
   */
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
      forestEnemy.updateWeatherMode(weather, display);
    }
  }
}


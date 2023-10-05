package game.grounds.environments.forestenemyground;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.enemies.forestenemy.RedWolf;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

/**
 * The Bushes class represents a type of ground in the forest environment where Red Wolves can spawn.
 * It extends the ForestEnemySpawnableGround class and provides functionality to update Red Wolf spawning rates
 * based on the current weather conditions.
 *
 * The class adjusts Red Wolf spawning rates according to the weather. During sunny weather, Red Wolf spawning rates decrease,
 * making them less active, while during rainy weather, the rates increase, making them more active.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <R> The type of Red Wolf spawner associated with this Bushes instance.
 * @see ForestEnemySpawnableGround
 * @see Weather
 * @see WeatherControllable
 */
public class Bushes<R extends RedWolf> extends ForestEnemySpawnableGround<R> {

  /**
   * Constructor to create a Bushes instance.
   *
   * @param redWolfSpawner The spawner for Red Wolves associated with this Bushes instance.
   */
  public Bushes(Spawner<R> redWolfSpawner){
    super('m', 30, redWolfSpawner);
  }

  /**
   * Updates the Red Wolf spawning rate based on the current weather conditions and informs any associated ForestEnemies.
   *
   * @param weather The current weather.
   * @param display The display interface to show weather-related messages.
   */
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
    for (WeatherControllable forestEnemy: forestEnemyList){
      forestEnemy.updateWeatherMode(weather, display);
    }
  }
}

package game.grounds.environments;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.ForestKeeper;
import game.spawners.ForestKeeperSpawner;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

import java.util.ArrayList;

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
 * @see EnemySpawnableGround
 * @see WeatherControllable
 */
public class ForestHut<F extends ForestKeeper> extends EnemySpawnableGround<F> implements WeatherControllable {
  private ArrayList<WeatherControllable> forestKeeperList;
  /**
   * Constructor to create a Hut instance.
   *
   * @param forestKeeperSpawner The spawner for Forest Keepers associated with this type of ground.
   */
  public ForestHut(ForestKeeperSpawner forestKeeperSpawner){
    super('h', 15, forestKeeperSpawner);
    forestKeeperList = new ArrayList<>();
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
    for(WeatherControllable forestEnemy: forestKeeperList){
      forestEnemy.updateWeatherMode(weather, display);
    }
  }

  /**
   * Handles the spawning of forest enemies on this ground based on the spawn rate and the absence of actors at the location.
   *
   * @param location The location on the map where the spawning occurs.
   */
  @Override
  public void tick(Location location) {
    if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
      ForestKeeper forestKeeper = spawner.spawn();
      location.addActor(forestKeeper);
      forestKeeperList.add(forestKeeper);
      enemyList.add(forestKeeper);
    }
    if (resetRequired){
      resetAction(location);
    }
  }

  @Override
  public void resetAction(Location location) {
    super.resetAction(location);
    forestKeeperList.clear();
  }

}


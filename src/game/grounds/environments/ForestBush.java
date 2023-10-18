package game.grounds.environments;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.forestenemy.RedWolf;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

import java.util.ArrayList;

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
 * @see EnemySpawnableGround
 * @see Weather
 * @see WeatherControllable
 */
public class ForestBush<R extends RedWolf> extends EnemySpawnableGround<R> implements WeatherControllable{
  private ArrayList<WeatherControllable> redWolfList;
  /**
   * Constructor to create a Bushes instance.
   *
   * @param redWolfSpawner The spawner for Red Wolves associated with this Bushes instance.
   */
  public ForestBush(Spawner<R> redWolfSpawner){
    super('m', 30, redWolfSpawner);
    redWolfList = new ArrayList<>();
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
    for (WeatherControllable forestEnemy: redWolfList){
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
      ForestEnemy forestEnemy = spawner.spawn();
      location.addActor(forestEnemy);
      redWolfList.add(forestEnemy);
      enemyList.add(forestEnemy);
    }
    if (isPlayerDead){
      removeEnemy(location.map());
      setPlayerDead();
    }
  }

  public void removeEnemy(GameMap map){
    for (Enemy enemy : enemyList){
      enemy.playerDead();
      enemy.unconscious(map);
    }
    redWolfList.clear();
  }
}

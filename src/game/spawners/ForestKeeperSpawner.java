package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;
import game.weather.WeatherControl;


public class ForestKeeperSpawner implements Spawner{

  /**
   * Spawn the Forest Keeper enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location, WeatherControl weatherControl) {
    double spawnRate = 0.15;  // default spawn rate

    if ("sunny".equals(weatherControl.getCurrentWeather())) {
      spawnRate = 0.30;  // double the rate when sunny
    }

    if (Math.random() <= spawnRate && !location.containsAnActor()) {
      location.addActor(new ForestKeeper());
    }
  }



}

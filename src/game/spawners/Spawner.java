package game.spawners;

import game.weather.WeatherControl;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Represent a spawner of an enemy
 */
public interface Spawner {

  /**
   * @param location the location to spawn the enemy
   */
  void spawn(Location location, WeatherControl WeatherControl);

}

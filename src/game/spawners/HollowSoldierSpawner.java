package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;
import game.weather.WeatherControl;


/**
 * A class that represents spawner of Hollow Soldier
 */
public class HollowSoldierSpawner implements Spawner{

  /**
   * Spawn the Hollow Soldier enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location, WeatherControl weatherControl) {
    double spawnRate = 0.10;  // default spawn rate
    // No weather-specific behavior for HollowSoldier
    if (Math.random() <= spawnRate && !location.containsAnActor()) {
      location.addActor(new HollowSoldier());
    }
  }

}



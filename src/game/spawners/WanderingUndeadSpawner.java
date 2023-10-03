package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;
import game.weather.WeatherControl;


/**
 * A class that represents spawner of Wandering Undead
 */
public class WanderingUndeadSpawner implements Spawner{

  /**
   * Spawn the Wandering Undead enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location, WeatherControl weatherControl) {
    double spawnRate = 0.25;  // default spawn rate
    // No weather-specific behavior for WanderingUndead
    if (Math.random() <= spawnRate && !location.containsAnActor()) {
      location.addActor(new WanderingUndead());
    }
  }



}

package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.RedWolf;
import game.weather.WeatherControl;


public class RedWolfSpawner implements Spawner{

  /**
   * Spawn the Red Wolf enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location, WeatherControl weatherControl){
    double spawnRate = "sunny".equals(weatherControl.getCurrentWeather()) ? 0.30 : 0.45;
    if (Math.random() <= spawnRate && !location.containsAnActor()) {
      location.addActor(new RedWolf());
    }
  }




}

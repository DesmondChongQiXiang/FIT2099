package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;
import game.weather.WeatherControl;

public abstract class EnemySpawnableGround extends Ground {

  /**
   * Enemy Spawner
   */
  private Spawner spawner;
  private WeatherControl weatherControl;


  /**
   * Constructor.
   */
  public EnemySpawnableGround(char displayChar, Spawner spawner){
    super(displayChar);
    this.spawner = spawner;
  }
  public void setWeatherControl(WeatherControl weatherControl) {
    this.weatherControl = weatherControl;
  }

  /**
   * Graveyard can spawn an enemy over time.
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    spawner.spawn(location, weatherControl);
  }

}

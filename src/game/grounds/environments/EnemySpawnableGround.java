package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;


/**
 * An abstract class for ground/environment which is used to spawn enemy each turn/tick.
 *
 * @author Yoong Qian Xin
 *
 * @see Ground
 */
public abstract class EnemySpawnableGround extends Ground {

  /**
   * Enemy Spawner
   */
  private Spawner spawner;

  /**
   * Constructor.
   *
   * @param displayChar Character to display for this type of environment
   * @param spawner To determine which enemy that can spawn on the specific type of environment
   */
  public EnemySpawnableGround(char displayChar, Spawner spawner){
    super(displayChar);
    this.spawner = spawner;
  }

  /**
   * Different environment can spawn an enemy over time.
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    spawner.spawn(location);
  }


}

package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;

public abstract class EnemySpawnableGround extends Ground {

  /**
   * Enemy Spawner
   */
  private Spawner spawner;

  /**
   * Constructor.
   */
  public EnemySpawnableGround(char displayChar, Spawner spawner){
    super(displayChar);
    this.spawner = spawner;
  }

  /**
   * Graveyard can spawn an enemy over time.
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    spawner.spawn(location);
  }


}

package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.spawners.Spawner;

public abstract class EnemySpawnableGround extends Ground {

  /**
   * the chance of spawn an enemy
   */
  private int spawnRate;

  /**
   * the spawner of enemy
   */
  private Spawner spawner;

  /**
   * Constructor.
   */
  public EnemySpawnableGround(char displayChar, int spawnRate, Spawner spawner){
    super(displayChar);
    this.spawnRate = spawnRate;
    this.spawner = spawner;
  }

  /**
   * Graveyard can spawn an enemy over time.
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    if (Math.random() <= ((double)spawnRate/100) && !location.containsAnActor()) {
      location.addActor(spawner.spawn());
    }
  }

}

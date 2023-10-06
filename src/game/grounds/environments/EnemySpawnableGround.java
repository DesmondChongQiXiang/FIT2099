package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.spawners.Spawner;

/**
 * The EnemySpawnableGround class represents a type of ground in the game world where enemies can spawn over time.
 * It extends the Ground class and provides a mechanism for controlling the spawning of enemies on this type of ground.
 *
 * This class defines the spawn rate and uses a spawner to create and add enemies to the location if the spawn condition is met.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <E> The type of enemy that can spawn on this type of ground.
 * @see Ground
 */
public abstract class EnemySpawnableGround<E extends Enemy> extends Ground {

  /**
   * The chance of spawning an enemy on this type of ground.
   */
  protected int spawnRate;

  /**
   * The spawner used to create and spawn enemies.
   */
  protected Spawner<E> spawner;

  /**
   * Constructor to create an EnemySpawnableGround instance.
   *
   * @param displayChar The character representation of this type of ground.
   * @param spawnRate   The spawn rate at which enemies appear on this type of ground.
   * @param spawner     The spawner for enemies associated with this type of ground.
   */
  public EnemySpawnableGround(char displayChar, int spawnRate, Spawner<E> spawner){
    super(displayChar);
    this.spawnRate = spawnRate;
    this.spawner = spawner;
  }

  /**
   * Called at each game tick to determine if an enemy should spawn on this type of ground.
   *
   * @param location The location of the ground.
   */
  @Override
  public void tick(Location location) {
    if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
      location.addActor(spawner.spawn());
    }
  }

  /**
   * Sets the spawn rate for this type of ground.
   *
   * @param spawnRate The new spawn rate to set.
   */
  public void setSpawnRate(int spawnRate) {
    this.spawnRate = spawnRate;
  }
}


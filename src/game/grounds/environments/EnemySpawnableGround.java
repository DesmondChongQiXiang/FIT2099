package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.reset.ResetNotifiable;
import game.reset.Resettable;
import game.spawners.Spawner;


/**
 * The EnemySpawnableGround class represents a type of ground in the game world where enemies can spawn over time.
 * It extends the Ground class and provides a mechanism for controlling the spawning of enemies on this type of ground.
 *
 * This class defines the spawn rate and uses a spawner to create and add enemies to the location if the spawn condition is met.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Ground
 */
public abstract class EnemySpawnableGround extends Ground implements ResetNotifiable, Resettable {

  /**
   * The spawner used to create and spawn enemies.
   */
  protected Spawner spawner;
  protected boolean resetRequired;

  /**
   * Constructor to create an EnemySpawnableGround instance.
   *
   * @param displayChar The character representation of this type of ground.
   * @param spawner     The spawner for enemies associated with this type of ground.
   */
  public EnemySpawnableGround(char displayChar,Spawner spawner){
    super(displayChar);
    this.spawner = spawner;
    this.resetRequired = false;
  }

  /**
   * Called at each game tick to determine if an enemy should spawn on this type of ground.
   *
   * @param location The location of the ground.
   */
  @Override
  public void tick(Location location) {
    spawner.spawn(location);
    if (resetRequired){
      reset(location);
      resetRequired = false;
    }
  }

  /**
   * Notifies the ground that a reset is required for the associated spawner.
   */
  @Override
  public void notifyReset() {
    resetRequired = true;
  }

  @Override
  public void reset(Location location){
    for (Enemy enemy: spawner.getEnemyList()){
      enemy.reset(location);
    }
  }
}


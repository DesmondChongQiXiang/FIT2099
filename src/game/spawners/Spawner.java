package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.reset.Resettable;
import java.util.ArrayList;

/**
 * An abstract class representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 *
 * Implementations of this interface handle the creation and placement of enemy actors at predefined locations in the game world.
 * The specific criteria for spawning an enemy actor may vary depending on the implementing class.
 *
 * @see Resettable
 * @author MA_AppliedSession1_Group7
 */
public abstract class Spawner implements Resettable {

  /**
   * The spawn rate, representing the chance of spawning an enemy (in percentage).
   */
  protected int spawnRate;

  /**
   * A list of enemy actors spawned by this spawner.
   */
  protected ArrayList<Enemy> enemyList;

  /**
   * Constructor for the spawner.
   *
   * @param spawnRate The spawn rate, indicating the chance of enemy spawning (in percentage).
   */
  public Spawner(int spawnRate){
    this.spawnRate = spawnRate;
    this.enemyList = new ArrayList<>();
  }

  /**
   * Spawns an enemy actor at the specified location.
   *
   * @param location The location at which the enemy actor should be spawned.
   */
  public void spawn(Location location){
    if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
      Enemy enemy = createEnemy();
      location.addActor(enemy);
      enemyList.add(enemy);
    }
  };

  /**
   * Abstract method for creating an enemy actor.
   *
   * @return The enemy actor created by this spawner.
   */
  public abstract Enemy createEnemy();

  /**
   * Resets the state of all enemy actors spawned by this spawner in the specified location.
   *
   * This method iterates through the list of enemy actors spawned by this spawner and calls the reset method
   * for each of them, allowing them to reset their state as required.
   *
   * @param location The location at which the reset is performed, typically the location where the spawner is located.
   * @see Enemy#reset(Location)
   */
  @Override
  public void reset(Location location){
    for (Enemy enemy: enemyList){
      enemy.reset(location);
    }
  }
}


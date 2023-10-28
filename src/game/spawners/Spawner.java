package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.reset.Resettable;
import java.util.ArrayList;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 *
 * Implementations of this interface handle the creation and placement of enemy actors at predefined locations in the game world.
 * The specific criteria for spawning an enemy actor may vary depending on the implementing class.
 *
 * @see Resettable
 *
 * @author MA_AppliedSession1_Group7
 */
public abstract class Spawner implements Resettable {
  protected int spawnRate;
  /**
   * A list of enemy actors spawned by this spawner.
   */
  protected ArrayList<Enemy> enemyList;

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

  public abstract Enemy createEnemy();

  @Override
  public void reset(Location location){
    for (Enemy enemy: enemyList){
      enemy.reset(location);
    }
  }
}


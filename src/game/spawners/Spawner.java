package game.spawners;


import edu.monash.fit2099.engine.positions.Location;
import game.ResetAction;
import game.actors.enemies.Enemy;

import java.util.ArrayList;

/**
 * An interface representing a spawner for enemy actors in the game world.
 * Classes implementing this interface are responsible for spawning enemy actors at specified locations.
 *
 * @author MA_AppliedSession1_Group7
 */
public abstract class Spawner<E extends Enemy> implements ResetAction{
  protected int spawnRate;
  protected ArrayList<Enemy> enemyList;

  public Spawner(int spawnRate){
    this.spawnRate = spawnRate;
    this.enemyList = new ArrayList<>();
  }
  /**
   * Spawns an enemy actor at the specified location.
   */
  public void spawn(Location location) {
    if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
      Enemy enemy = createEnemy();
      location.addActor(enemy);
      enemyList.add(enemy);
    }
  }

  public abstract E createEnemy();

  public void setSpawnRate(int spawnRate) {
    this.spawnRate = spawnRate;
  }

  public void resetAction(Location location) {
    for (Enemy enemy : enemyList){
      enemy.resetAction(location);
      enemy.reset();
    }
  }
}

package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;

/**
 * A class that represents the Hut.
 * The graveyard can spawn an enemy at a time.
 *
 * @author Yoong Qian Xin
 */
public class Hut extends Ground {
  private Enemy enemy;
  private double spawnRate;

  /**
   * Constructor.
   *
   * @param enemy The enemy to be spawned on Hut in certain chance of time
   * @param spawnRate The chance of enemy to be spawned at every turn
   */
  public Hut(Enemy enemy, double spawnRate){
    super('h');
    this.enemy = enemy;
    this.spawnRate = spawnRate;
  }

  /**
   * The enemy that will be spawned if spawn rate is met.
   *
   * @param location The location of the Hut
   */
  @Override
  public void tick(Location location) {
    if (Math.random() <= enemy.getSpawnRate() && !location.containsAnActor()){
      location.addActor(enemy.spawnInstance());  // add spawned enemies to the location based on its spawn rate.
    }
  }


}

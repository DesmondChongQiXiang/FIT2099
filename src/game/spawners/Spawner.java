package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;

/**
 * Represent a spawner of an enemy
 */
public interface Spawner {
  Enemy spawn();


}

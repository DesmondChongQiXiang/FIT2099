package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;

/**
 * The `EnemySpawnableGround` class represents a type of ground environment where enemies can spawn over time.
 * It extends the `Ground` class and provides a mechanism for spawning enemies using a specified `Spawner`.
 */
public abstract class EnemySpawnableGround extends Ground {

  /**
   * The spawner responsible for spawning enemies on this ground.
   */
  private Spawner spawner;

  /**
   * Constructs a new instance of the `EnemySpawnableGround` class.
   *
   * @param displayChar The character used to display this ground on the map.
   * @param spawner     The spawner responsible for spawning enemies on this ground.
   */
  public EnemySpawnableGround(char displayChar, Spawner spawner){
    super(displayChar);
    this.spawner = spawner;
  }

  /**
   * Called on each game tick to potentially spawn an enemy on this ground.
   *
   * @param location The location of this ground on the map.
   */
  @Override
  public void tick(Location location) {
    spawner.spawn(location);
  }


}

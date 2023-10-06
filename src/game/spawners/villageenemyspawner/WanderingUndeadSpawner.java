package game.spawners.villageenemyspawner;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.villageenemy.WanderingUndead;
import game.spawners.Spawner;

/**
 * A class that represents spawner of Wandering Undead
 */
public class WanderingUndeadSpawner implements VillageEnemySpawner {

  /**
   * Spawn the Wandering Undead enemy
   */
  @Override
  public WanderingUndead spawn(){
    return new WanderingUndead();
  }


}

package game.spawners.villageenemyspawner;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.villageenemy.HollowSoldier;
import game.spawners.Spawner;

/**
 * A class that represents spawner of Hollow Soldier
 */
public class HollowSoldierSpawner implements VillageEnemySpawner {

  /**
   * Spawn the Hollow Soldier enemy
   */
  @Override
  public HollowSoldier spawn(){
    return new HollowSoldier();
  }


}

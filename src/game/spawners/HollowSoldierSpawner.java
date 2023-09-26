package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;

/**
 * A class that represents spawner of Hollow Soldier
 */
public class HollowSoldierSpawner implements Spawner{

  /**
   * Spawn the Hollow Soldier enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.10 && !location.containsAnActor()) {
      location.addActor(new HollowSoldier());
    }
  }


}

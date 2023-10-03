package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;

/**
 * A spawner class responsible for spawning the Hollow Soldier enemy in the game world.
 * The Hollow Soldier has a 10% chance of spawning at the specified location if it does not already contain an actor.
 */
public class HollowSoldierSpawner implements Spawner{

  /**
   * Spawn the Hollow Soldier enemy at the specified location if conditions are met.
   *
   * @param location The location where the enemy is potentially spawned.
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.10 && !location.containsAnActor()) {
      location.addActor(new HollowSoldier());
    }
  }


}

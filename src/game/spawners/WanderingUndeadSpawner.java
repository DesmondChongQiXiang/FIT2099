package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;

/**
 * A spawner class responsible for spawning the Wandering Undead enemy in the game world.
 * The Wandering Undead has a 25% chance of spawning at the specified location if it does not already contain an actor.
 */
public class WanderingUndeadSpawner implements Spawner{

  /**
   * Spawn the Wandering Undead enemy at the specified location if conditions are met.
   *
   * @param location The location where the enemy is potentially spawned.
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.25 && !location.containsAnActor()) {
      location.addActor(new WanderingUndead());
    }
  }


}

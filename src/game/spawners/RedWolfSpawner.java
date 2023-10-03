package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.RedWolf;

/**
 * A spawner class responsible for spawning the Red Wolf enemy in the game world.
 * The Red Wolf has a 30% chance of spawning at the specified location if it does not already contain an actor.
 */
public class RedWolfSpawner implements Spawner{

  /**
   * Spawn the Red Wolf enemy at the specified location if conditions are met.
   *
   * @param location The location where the enemy is potentially spawned.
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.30 && !location.containsAnActor()) {
      location.addActor(new RedWolf());
    }
  }
}

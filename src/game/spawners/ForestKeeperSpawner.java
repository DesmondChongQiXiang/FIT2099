package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;

/**
 * A spawner class responsible for spawning the Forest Keeper enemy in the game world.
 * The Forest Keeper has a 15% chance of spawning at the specified location if it does not already contain an actor.
 */
public class ForestKeeperSpawner implements Spawner{

  /**
   * Spawn the Forest Keeper enemy at the specified location if conditions are met.
   *
   * @param location The location where the enemy is potentially spawned.
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.15 && !location.containsAnActor()) {
      location.addActor(new ForestKeeper());
    }
  }


}

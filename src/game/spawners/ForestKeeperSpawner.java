package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;

public class ForestKeeperSpawner implements Spawner{

  /**
   * Spawn the Forest Keeper enemy
   *
   * @param location the location of spawn the enemy
   */
  @Override
  public void spawn(Location location){
    if (Math.random() <= 0.15 && !location.containsAnActor()) {
      location.addActor(new ForestKeeper());
    }
  }


}

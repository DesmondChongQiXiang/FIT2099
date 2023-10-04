package game.spawners.villageenemyspawner;

import game.actors.enemies.villageenemy.WanderingUndead;

/**
 * A spawner class responsible for spawning the Wandering Undead enemy in the game world.
 * The Wandering Undead has a 25% chance of spawning at the specified location if it does not already contain an actor.
 */
public class WanderingUndeadSpawner implements VillageEnemySpawner {

  /**
   * Spawn the Wandering Undead enemy at the specified location if conditions are met.
   */
  @Override
  public WanderingUndead spawn(){
    return new WanderingUndead();
  }


}

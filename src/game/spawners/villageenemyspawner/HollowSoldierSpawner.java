package game.spawners.villageenemyspawner;

import game.actors.enemies.villageenemy.HollowSoldier;

/**
 * A spawner class responsible for spawning the Hollow Soldier enemy in the game world.
 * The Hollow Soldier has a 10% chance of spawning at the specified location if it does not already contain an actor.
 */
public class HollowSoldierSpawner implements VillageEnemySpawner {

  /**
   * Spawn the Hollow Soldier enemy at the specified location if conditions are met.
   */
  @Override
  public HollowSoldier spawn(){
    return new HollowSoldier();
  }


}

package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.HollowSoldier;

/**
 * The `HollowSoldierSpawner` class is responsible for spawning instances of the Hollow Soldier enemy actor
 * at specific locations within the game world.
 */
public class HollowSoldierSpawner implements Spawner {
    /**
     * Spawns an instance of the HollowSoldier enemy actor at the specified location within the game world, if the spawn conditions are met.
     *
     * @param location The location at which the enemy actor should be spawned.
     * @return a Hollow Soldier that has been spawned.
     */
    public Enemy spawn(Location location){
        if (Math.random() <= ((double) 10 / 100) && !location.containsAnActor()) {
            Enemy hollowSoldier = new HollowSoldier();
            location.addActor(hollowSoldier);
            return hollowSoldier;
        }
        return null;
    };
}


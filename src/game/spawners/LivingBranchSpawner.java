package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.LivingBranch;

/**
 * The `LivingBranchSpawner` class is responsible for spawning instances of the LivingBranch enemy actor at specific
 * locations within the game world.
 */
public class LivingBranchSpawner implements Spawner {
    /**
     * Spawns an instance of the LivingBranch enemy actor at the specified location within the game world, if the spawn conditions are met.
     *
     * @param location The location at which the enemy actor should be spawned.
     * @return a Living Branch that has been spawned.
     */
    public Enemy spawn(Location location){
        if (Math.random() <= ((double) 90 / 100) && !location.containsAnActor()) {
            Enemy livingBranch = new LivingBranch();
            location.addActor(livingBranch);
            return livingBranch;
        }
        return null;
    };
}


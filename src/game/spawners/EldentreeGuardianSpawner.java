package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.EldentreeGuardian;
import game.actors.enemies.Enemy;

/**
 * The `EldentreeGuardianSpawner` class is responsible for spawning instances of the EldentreeGuardian enemy actor
 * at specific locations within the game world.
 */
public class EldentreeGuardianSpawner implements Spawner {
    /**
     * Spawns an instance of the Eldentree Guardian enemy actor at the specified location within the game world, if the spawn conditions are met.
     *
     * @param location The location at which the enemy actor should be spawned.
     * @return an Eldentree Guardian that has been spawned.
     */
    public Enemy spawn(Location location){
        if (Math.random() <= ((double) 20 / 100) && !location.containsAnActor()) {
            Enemy eldentreeGuardian = new EldentreeGuardian();
            location.addActor(eldentreeGuardian);
            return eldentreeGuardian;
        }
        return null;
    };
}

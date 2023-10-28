package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.EldentreeGuardian;
import game.actors.enemies.Enemy;
import java.util.ArrayList;

/**
 * The `EldentreeGuardianSpawner` class is responsible for spawning instances of the EldentreeGuardian enemy actor
 * at specific locations within the game world.
 */
public class EldentreeGuardianSpawner implements Spawner {

    /**
     * A list of enemy actors spawned by this spawner.
     */
    protected ArrayList<Enemy> enemyList;

    /**
     * Constructs an `EldentreeGuardianSpawner` with an empty list of enemy actors.
     */
    public EldentreeGuardianSpawner() {
        this.enemyList = new ArrayList<>();
    }

    /**
     * Spawns an instance of the EldentreeGuardian enemy actor at the specified location within the game world.
     *
     * @param location The location where the EldentreeGuardian should be spawned.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 20 / 100) && !location.containsAnActor()) {
            Enemy enemy = new EldentreeGuardian();
            location.addActor(enemy);
            enemyList.add(enemy);
        }
    }

    /**
     * Resets the state of enemy actors spawned by this spawner at the specified location.
     *
     * @param location The location where the reset should occur.
     */
    @Override
    public void reset(Location location) {
        for (Enemy enemy : enemyList) {
            enemy.reset(location);
        }
    }
}

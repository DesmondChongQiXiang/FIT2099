package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.LivingBranch;

import java.util.ArrayList;

/**
 * The `LivingBranchSpawner` class is responsible for spawning instances of the LivingBranch enemy actor at specific
 * locations within the game world.
 */
public class LivingBranchSpawner implements Spawner {

    /**
     * A list of enemy actors spawned by this spawner.
     */
    protected ArrayList<Enemy> enemyList;

    /**
     * Constructs a `LivingBranchSpawner` with an empty list of enemy actors.
     */
    public LivingBranchSpawner() {
        this.enemyList = new ArrayList<>();
    }

    /**
     * Spawns an instance of the LivingBranch enemy actor at the specified location within the game world.
     *
     * @param location The location where the LivingBranch should be spawned.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 90 / 100) && !location.containsAnActor()) {
            Enemy enemy = new LivingBranch();
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


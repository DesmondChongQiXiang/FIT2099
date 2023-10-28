package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.HollowSoldier;
import java.util.ArrayList;

/**
 * The `HollowSoldierSpawner` class is responsible for spawning instances of the Hollow Soldier enemy actor
 * at specific locations within the game world.
 */
public class HollowSoldierSpawner implements Spawner {

    /**
     * A list of enemy actors spawned by this spawner.
     */
    protected ArrayList<Enemy> enemyList;

    /**
     * Constructs a `HollowSoldierSpawner` with an empty list of enemy actors.
     */
    public HollowSoldierSpawner() {
        this.enemyList = new ArrayList<>();
    }

    /**
     * Spawns an instance of the Hollow Soldier enemy actor at the specified location within the game world.
     *
     * @param location The location where the Hollow Soldier should be spawned.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 10 / 100) && !location.containsAnActor()) {
            Enemy enemy = new HollowSoldier();
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


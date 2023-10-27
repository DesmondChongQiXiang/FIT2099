package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.LivingBranch;

import java.util.ArrayList;

/**
 * Spawner for generating instances of the LivingBranch.
 */
public class LivingBranchSpawner implements Spawner{
    protected ArrayList<Enemy> enemyList;

    public LivingBranchSpawner() {
        this.enemyList = new ArrayList<>();
    }
    /**
     * Spawns an enemy actor at the specified location.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 90 / 100) && !location.containsAnActor()) {
            Enemy enemy = new LivingBranch();
            location.addActor(enemy);
            enemyList.add(enemy);
        }
    }

    @Override
    public void reset(Location location) {
        for (Enemy enemy : enemyList){
            enemy.reset(location);
        }
    }
}

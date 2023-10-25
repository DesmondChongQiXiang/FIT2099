package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.HollowSoldier;
import java.util.ArrayList;

/**
 * Spawner for generating instances of the Hollow Soldier.
 */
public class HollowSoldierSpawner implements Spawner{
    protected ArrayList<Enemy> enemyList;

    public HollowSoldierSpawner() {
        this.enemyList = new ArrayList<>();
    }
    /**
     * Spawns an enemy actor at the specified location.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 10 / 100) && !location.containsAnActor()) {
            Enemy enemy = new HollowSoldier();
            location.addActor(enemy);
            enemyList.add(enemy);
        }
    }

    @Override
    public void resetAction(Location location) {
        for (Enemy enemy : enemyList){
            enemy.resetAction(location);
            enemy.reset();
        }
    }
}

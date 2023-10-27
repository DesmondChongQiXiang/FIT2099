package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.WanderingUndead;
import java.util.ArrayList;

/**
 * Spawner for generating instances of the Wandering Undead.
 */
public class WanderingUndeadSpawner implements Spawner{
    protected ArrayList<Enemy> enemyList;

    public WanderingUndeadSpawner() {
        this.enemyList = new ArrayList<>();
    }
    /**
     * Spawns an enemy actor at the specified location.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 25 / 100) && !location.containsAnActor()) {
            Enemy enemy = new WanderingUndead();
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

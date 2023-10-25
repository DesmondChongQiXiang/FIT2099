package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.EldentreeGuardian;
import game.actors.enemies.Enemy;
import java.util.ArrayList;

/**
 * Spawner for generating instances of the EldentreeGuardian.
 */
public class EldentreeGuardianSpawner implements Spawner{
    protected ArrayList<Enemy> enemyList;

    public EldentreeGuardianSpawner() {
        this.enemyList = new ArrayList<>();
    }
    /**
     * Spawns an enemy actor at the specified location.
     */
    public void spawn(Location location) {
        if (Math.random() <= ((double) 20 / 100) && !location.containsAnActor()) {
            Enemy enemy = new EldentreeGuardian();
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

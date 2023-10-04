package game.grounds.environments.forestenemyspawnableground;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.forestenemyspawner.ForestEnemySpawner;

import java.util.ArrayList;

public abstract class ForestEnemySpawnableGround extends EnemySpawnableGround {

    protected ArrayList<ForestEnemy> forestEnemyList;

    public ForestEnemySpawnableGround(char displayChar, int spawnRate, ForestEnemySpawner forestEnemySpawner){
        super(displayChar,spawnRate,forestEnemySpawner);
        this.forestEnemyList = new ArrayList<>();
    }

    @Override
    public void tick(Location location) {
        if (Math.random() <= ((double)spawnRate/100) && !location.containsAnActor()) {
            Enemy forestEnemy = spawner.spawn();
            forestEnemyList.add(forestEnemy);
            location.addActor(spawner.spawn());
        }
    }

    public abstract void sunnyMode();

    public abstract void rainyMode();
}

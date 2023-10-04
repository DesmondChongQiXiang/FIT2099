package game.grounds.environments.forestenemyspawnableground;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.Spawner;
import game.weathers.WeatherControllable;

import java.util.ArrayList;

public abstract class ForestEnemySpawnableGround<F extends ForestEnemy> extends EnemySpawnableGround<F> implements WeatherControllable {
    protected ArrayList<ForestEnemy> forestEnemyList;
    public ForestEnemySpawnableGround(char displayChar, int spawnRate, Spawner<F> forestEnemySpawner){
        super(displayChar,spawnRate,forestEnemySpawner);
        forestEnemyList = new ArrayList<>();
    }

    @Override
    public void tick(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            ForestEnemy forestEnemy = spawner.spawn();
            location.addActor(forestEnemy);
            forestEnemyList.add(forestEnemy);
        }
    }
}

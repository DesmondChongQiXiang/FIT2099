package game.grounds.environments.forest;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.Spawner;
import game.weathers.WeatherControllable;

import java.util.ArrayList;

/**
 * The ForestEnemySpawnableGround class represents a type of ground in the forest environment where forest enemies can spawn.
 * It extends the EnemySpawnableGround class and provides functionality to control the spawning of forest enemies based on weather conditions.
 *
 * This class maintains a list of forest enemies and defines the logic for spawning them on this type of ground.
 * The spawning rate is determined by the 'spawnRate' parameter, which can be influenced by weather conditions.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <F> The type of forest enemy that can spawn on this ground.
 * @see EnemySpawnableGround
 * @see WeatherControllable
 */
public abstract class ForestEnemySpawnableGround<F extends ForestEnemy> extends EnemySpawnableGround<F> implements WeatherControllable {
    protected ArrayList<WeatherControllable> forestEnemyList;

    /**
     * Constructor to create a ForestEnemySpawnableGround instance.
     *
     * @param displayChar The character used to represent this type of ground in the game.
     * @param spawnRate   The rate at which forest enemies spawn on this ground.
     * @param forestEnemySpawner The spawner for the forest enemy associated with this ground.
     */
    public ForestEnemySpawnableGround(char displayChar, int spawnRate, Spawner<F> forestEnemySpawner){
        super(displayChar, spawnRate, forestEnemySpawner);
        forestEnemyList = new ArrayList<>();
    }

    /**
     * Handles the spawning of forest enemies on this ground based on the spawn rate and the absence of actors at the location.
     *
     * @param location The location on the map where the spawning occurs.
     */
    @Override
    public void tick(Location location) {
        if (Math.random() <= ((double) spawnRate / 100) && !location.containsAnActor()) {
            ForestEnemy forestEnemy = spawner.spawn();
            location.addActor(forestEnemy);
            forestEnemyList.add(forestEnemy);
        }
    }
}



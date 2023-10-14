package game.grounds.environments.sanctuary;

import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.sanctuaryenemy.SanctuaryEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.Spawner;
import game.weathers.WeatherControllable;

import java.util.ArrayList;

public abstract class SanctuaryEnemySpawnableGround<S extends SanctuaryEnemy> extends EnemySpawnableGround<S> {

    /**
     * Constructor to create an EnemySpawnableGround instance.
     *
     * @param displayChar The character representation of this type of ground.
     * @param spawnRate   The spawn rate at which enemies appear on this type of ground.
     * @param spawner     The spawner for enemies associated with this type of ground.
     */
    public SanctuaryEnemySpawnableGround(char displayChar, int spawnRate, Spawner<S> spawner) {
        super(displayChar, spawnRate, spawner);
    }
}

package game.grounds.environments.villageenemyground;

import game.actors.enemies.villageenemy.VillageEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.Spawner;


/**
 * The VillageEnemySpawnableGround class represents a type of ground in a village environment where various village enemies can spawn.
 * It extends the EnemySpawnableGround class and provides a generic mechanism for controlling the spawning of village enemies.
 *
 * This class sets the specific character representation and spawn rate for village enemy spawning in different village environments.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <V> The type of village enemy that can spawn in this type of ground.
 * @see EnemySpawnableGround
 */
public abstract class VillageEnemySpawnableGround<V extends VillageEnemy> extends EnemySpawnableGround<V> {

    /**
     * Constructor to create a VillageEnemySpawnableGround instance.
     *
     * @param displayChar The character representation of this type of ground.
     * @param spawnRate   The spawn rate at which village enemies appear on this type of ground.
     * @param villageEnemySpawner The spawner for village enemies associated with this type of ground.
     */
    public VillageEnemySpawnableGround(char displayChar, int spawnRate, Spawner<V> villageEnemySpawner){
        super(displayChar, spawnRate, villageEnemySpawner);
    }
}


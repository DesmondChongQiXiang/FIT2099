package game.grounds.environments.forestenemyspawnableground;

import game.grounds.environments.EnemySpawnableGround;
import game.spawners.forestenemyspawner.ForestEnemySpawner;

public abstract class ForestEnemySpawnableGround extends EnemySpawnableGround {
    public ForestEnemySpawnableGround(char displayChar, int spawnRate, ForestEnemySpawner forestEnemySpawner){
        super(displayChar,spawnRate,forestEnemySpawner);
    }
}

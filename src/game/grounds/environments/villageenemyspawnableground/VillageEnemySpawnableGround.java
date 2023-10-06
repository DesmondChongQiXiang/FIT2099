package game.grounds.environments.villageenemyspawnableground;

import game.grounds.environments.EnemySpawnableGround;
import game.spawners.forestenemyspawner.ForestEnemySpawner;
import game.spawners.villageenemyspawner.VillageEnemySpawner;

public class VillageEnemySpawnableGround extends EnemySpawnableGround {
    public VillageEnemySpawnableGround(char displayChar, int spawnRate, VillageEnemySpawner villageEnemySpawner){
        super(displayChar,spawnRate,villageEnemySpawner);
    }
}

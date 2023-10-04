package game.grounds.environments.villageenemyspawnableground;

import game.actors.enemies.villageenemy.VillageEnemy;
import game.grounds.environments.EnemySpawnableGround;
import game.spawners.Spawner;


public abstract class VillageEnemySpawnableGround<V extends VillageEnemy> extends EnemySpawnableGround<V> {
    public VillageEnemySpawnableGround(char displayChar, int spawnRate, Spawner<V> villageEnemySpawner){
        super(displayChar,spawnRate,villageEnemySpawner);
    }
}

package game.spawners.forestenemyspawner;

import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.villageenemy.VillageEnemy;
import game.spawners.Spawner;

public interface ForestEnemySpawner extends Spawner {
    ForestEnemy spawn();
}

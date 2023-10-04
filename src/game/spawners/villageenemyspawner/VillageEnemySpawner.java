package game.spawners.villageenemyspawner;

import game.actors.enemies.villageenemy.VillageEnemy;
import game.spawners.Spawner;

public interface VillageEnemySpawner extends Spawner {
    VillageEnemy spawn();
}

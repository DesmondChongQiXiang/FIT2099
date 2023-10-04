package game.spawners.forestenemyspawner;


import game.actors.enemies.Enemy;
import game.spawners.Spawner;

public interface ForestEnemySpawner extends Spawner {
    Enemy spawn();
}

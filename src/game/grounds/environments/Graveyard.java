package game.grounds.environments;

import game.spawners.Spawner;

/**
 * The `Graveyard` class represents a specific type of ground environment that allows the spawning of enemies over time.
 * It extends the `EnemySpawnableGround` class and is associated with a specific `Spawner` for spawning enemies.
 */
public class Graveyard extends EnemySpawnableGround {

    /**
     * Constructor to create a `Graveyard` instance.
     *
     * @param spawner The spawner responsible for spawning enemies in the graveyard.
     */
    public Graveyard(Spawner spawner){
        super('n', spawner);
    }

}

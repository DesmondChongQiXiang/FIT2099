package game.grounds.environments;

import game.spawners.Spawner;

/**
 * A class representing a Hut in the game, which is an EnemySpawnableGround.
 *
 */
public class Hut extends EnemySpawnableGround{

    /**
     * Constructor to create a Hut instance.
     *
     * @param spawner The spawner for enemies associated with this type of ground.
     */
    public Hut(Spawner spawner) {
        super('h', spawner);
    }
}

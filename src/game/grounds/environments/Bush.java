package game.grounds.environments;

import game.spawners.Spawner;

/**
 * A class representing a bush that can be spawned with enemies using a specified spawner.
 * This class extends the EnemySpawnableGround class.
 *
 */
public class Bush extends EnemySpawnableGround{

    /**
     * Constructor for creating a bush with a specified spawner.
     *
     * @param spawner The spawner used to generate enemies on this ground.
     */
    public Bush(Spawner spawner) {
        super('m', spawner);
    }
}

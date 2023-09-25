package game.grounds.environments;

import game.spawners.Spawner;

/**
 * Represents a type of ground called "Graveyard" that can spawn enemies.
 */
public class Graveyard extends EnemySpawnableGround {

    /**
     * Constructor.
     *
     * @param spawner The enemy spawner associated with this Graveyard.
     */
    public Graveyard(Spawner spawner){
        super('n', spawner);
    }


}

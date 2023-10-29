package game.grounds.environments;

import game.spawners.Spawner;

/**
 * A class representing a Graveyard in the game, which is an EnemySpawnableGround.
 *
 */
public class Graveyard extends EnemySpawnableGround{

    /**
     * Constructor to create a Graveyard instance.
     *
     * @param spawner The spawner for enemies associated with this type of ground.
     */
    public Graveyard(Spawner spawner){
        super('n',  spawner);
    }
}

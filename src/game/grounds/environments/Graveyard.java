package game.grounds.environments;

import game.spawners.Spawner;


public class Graveyard extends EnemySpawnableGround {

    /**
     * Constructor.
     */
    public Graveyard(Spawner spawner){
        super('n', spawner);
    }


}

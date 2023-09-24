package game.grounds.enemygrounds;

import game.spawners.ForestKeeperSpawner;
import game.spawners.Spawner;

public class EmptyHut extends EnemyGround{
    /**
     * Constructor.
     */
    public EmptyHut(){
        super('h', new ForestKeeperSpawner());
    }
}

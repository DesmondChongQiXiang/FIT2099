package game.grounds.enemygrounds;

import game.spawners.ForestKeeperSpawner;
import game.spawners.RedWolfSpawner;

public class Bush extends EnemyGround{
    /**
     * Constructor.
     */
    public Bush(){
        super('m', new RedWolfSpawner());
    }
}

package game.grounds.enemygrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;


public class Graveyard extends EnemyGround {
    /**
     * Constructor.
     */
    public Graveyard(Spawner spawner){
        super('n', spawner);
    }
}

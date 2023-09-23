package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawner.Spawner;


public class Graveyard extends Ground {
    /**
     * Enemy Spawner
     */
    private Spawner spawner;

    /**
     * Constructor.
     */
    public Graveyard(Spawner spawner){
        super('n');
        this.spawner = spawner;
    }

    /**
     * Graveyard can spawn an enemy over time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        spawner.spawn(location);
    }

}

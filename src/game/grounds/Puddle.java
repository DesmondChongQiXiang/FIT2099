package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents a puddle in the game world.
 * This ground type is represented by the character '~' in the game.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class Puddle extends Ground {

    /**
     * Constructor to create a Puddle object.
     * Initializes it with the character '~' to represent a puddle.
     */
    public Puddle() {
        super('~');
    }
}

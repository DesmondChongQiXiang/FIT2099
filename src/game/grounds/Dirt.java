package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;

/**
 * The `Dirt` class represents a type of ground environment, specifically bare dirt.
 * It extends the `Ground` class and is represented by the character '.' in the game map.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Dirt extends Ground {

    /**
     * Constructor to create a `Dirt` instance.
     */
    public Dirt() {
        super('.');
    }


}
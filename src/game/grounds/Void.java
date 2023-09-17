package game.grounds;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents a void in the game world.
 * This ground type is represented by the character '+' in the game.
 * When an actor enters this void, they become unconscious.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class Void extends Ground {

    /**
     * Constructor to create a Void object.
     * Initializes it with the character '+' to represent a void.
     */
    public Void() {
        super('+');
    }

    /**
     * Called on each game tick to perform actions associated with the void.
     * If the location contains an actor, it makes the actor unconscious.
     *
     * @param location The location of the void in the game world.
     */
    @Override
    public void tick(Location location) {
        if(location.containsAnActor()){
            new Display().println(location.getActor().unconscious(location.map()));
        }
    }


}

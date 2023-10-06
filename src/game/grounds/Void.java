package game.grounds;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Ability;

/**
 * The `Void` class represents a dangerous void space on the game map. It is a type of ground environment
 * represented by the character '+' on the game map. Stepping on the void space without the 'Ability.ENTER_VOID'
 * capability will cause an actor to become unconscious.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Void extends Ground{
    /**
     * Constructor to create a `Void` instance. It is represented by the character '+'.
     */
    public Void() {
        super('+');
    }

    /**
     * Checks if an actor is on the void space and does not have the 'Ability.ENTER_VOID' capability. If so, it causes
     * the actor to become unconscious.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && !location.getActor().hasCapability(Ability.ENTER_VOID)){
            new Display().println(location.getActor().unconscious(location.map()));
        }
    }


}

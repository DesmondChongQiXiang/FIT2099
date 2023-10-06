package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Ability;

/**
 * The `Floor` class represents the floor inside a building. It is a type of ground environment
 * and is represented by the character '_' on the game map.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Floor extends Ground {

    /**
     * Constructor to create a `Floor` instance.
     */
    public Floor() {
        super('_');
    }

    /**
     * Checks whether the actor can enter this floor. Actors can enter if they have the ability to "enter floor."
     *
     * @param actor the Actor attempting to enter
     * @return true if the actor has the ability to enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_FLOOR);
    }


}

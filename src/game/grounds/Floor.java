package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actions.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Ong Chong How
 * @version 1.0
 */
public class Floor extends Ground {

    /**
     * Constructor to create a Floor object.
     * Initializes it with the character '_' to represent the floor inside a building.
     */
    public Floor() {
        super('_');
    }

    /**
     * Checks if an actor can enter this floor.
     *
     * @param actor The actor attempting to enter.
     * @return True if the actor has the capability to enter floors, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENABLE_ENTER_FLOOR);
    }
}

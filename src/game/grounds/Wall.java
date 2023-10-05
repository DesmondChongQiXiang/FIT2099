package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * The `Wall` class represents an impassable wall on the game map. It is a type of ground environment
 * represented by the character '#' on the game map. Actors are not allowed to enter or move through walls.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Wall extends Ground {

    /**
     * Constructor to create a `Wall` instance. It is represented by the character '#'.
     */
    public Wall() {
        super('#');
    }

    /**
     * Overrides the canActorEnter method to prevent any actor from entering the wall. Always returns false.
     *
     * @param actor The Actor that tried to enter.
     * @return False, indicating that no actor can enter the wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }


}

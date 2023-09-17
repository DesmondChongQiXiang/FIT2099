package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Ong Chong How
 *
 * @version 1.0
 */
public class Wall extends Ground {

    /**
     * Constructor to create a Wall object.
     * Initializes it with the character '#' to represent a wall.
     */
    public Wall() {
        super('#');
    }

    /**
     * Checks if an actor can enter this wall.
     *
     * @param actor The actor attempting to enter.
     * @return Always returns false, indicating that actors cannot enter a wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}

package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {
    /**
     * Constructor.
     */
    public Wall() {
        super('#');
    }

    /**
     * To not allow any actor enter it
     *
     * @param actor the Actor that tried to enter
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}

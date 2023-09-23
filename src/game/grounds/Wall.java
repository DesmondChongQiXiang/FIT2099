package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Yoong Qian Xin
 *
 * A class that represents the wall inside a building.
 */
public class Wall extends Ground {

    /**
     * Constructor.
     */
    public Wall() {
        super('#');
    }

    /**
     * Determines whether an actor can enter the floor tile.
     *
     * @param actor the actor attempting to enter the floor tile
     *
     * @return every actor cannot enter the wall, this method always return false
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}

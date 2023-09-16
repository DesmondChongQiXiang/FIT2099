package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Yoong Qian Xin
 *
 */
public class Floor extends Ground {
    /**
     * Constructor.
     */
    public Floor() {
        super('_');
    }


    /**
     * Determines whether an actor can enter the floor tile.
     *
     * @param actor the actor attempting to enter the floor tile
     *
     * @return true if the actor can enter the floor, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_FLOOR);
    }


}

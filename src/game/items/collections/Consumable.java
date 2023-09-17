package game.items.collections;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing items that can be consumed by actors in the game.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public interface Consumable {

    /**
     * Consumes the item and provides a numerical value indicating the effect of consumption.
     *
     * @param actor The actor consuming the item.
     * @return An integer value indicating the effect of consumption on the actor.
     */
    int consume(Actor actor);
}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface which will be implemented by the item which is consumable by actor.
 *
 * @author Yoong Qian Xin
 */
public interface Consumable {

    /**
     * Consume effect of the item
     * @param actor the actor who consumes the item
     *
     * @return The result string to be printed on the console
     */
    String consumedBy(Actor actor);


}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface which will be implemented by the item which is consumable by an actor.
 *
 * The implementing classes should provide a "consumedBy" method to define the consumption effect.
 *
 * @author : MA_AppliedSession1_Group7
 */
public interface Consumable {

    /**
     * Consume effect of the item.
     *
     * @param actor The actor who consumes the item.
     * @return The result string to be printed on the console.
     */
    String consumedBy(Actor actor);


}

package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
/**
 * Represent an item is consumable
 */

public interface Consumable {
    /**
     * @param actor the Actor acting
     * @return the String message of actor do consume action
     */
    String consume(Actor actor);
}

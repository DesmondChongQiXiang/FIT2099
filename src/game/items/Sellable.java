package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Sellable interface represents items that can be sold by an actor.
 *
 */
public interface Sellable {

    /**
     * Determines the logic for selling the item.
     *
     * @param actor The actor who is selling the item.
     * @return The selling price of the item.
     */
    int soldBy(Actor actor);
}

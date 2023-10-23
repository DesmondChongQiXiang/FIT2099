package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Sellable interface represents items that can be sold by an actor.
 * Actors implementing this interface have the ability to sell items and determine their selling price.
 *
 * @author MA_AppliedSession1_Group7
 */
public interface Sellable {

    /**
     * Determines the logic for selling the item and calculates its selling price.
     *
     * @param seller The seller who is selling the item.
     * @return The selling price of the item, typically in the game's currency.
     */
    String soldBy(Actor seller);
}

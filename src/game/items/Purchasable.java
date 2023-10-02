package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Purchasable interface represents items that can be purchased by an actor.
 */
public interface Purchasable{

    /**
     * Determines the logic for purchasing the item.
     *
     * @param buyer The actor who is purchasing the item.
     * @param purchasePrice the item purchase price
     * @return The purchase price of the item.
     */
    int purchasedBy(Actor buyer, int purchasePrice);
}

package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Purchasable interface represents items that can be purchased by an actor.
 *
 * @author MA_AppliedSession1_Group7
 */
public interface Purchasable{

    /**
     * Determines the logic for purchasing the item.
     *
     * @param buyer The actor who is purchasing the item.
     * @param purchasePrice The item purchase price.
     * @return The purchase price of the item.
     */
    String purchasedBy(Actor buyer, int purchasePrice);
}

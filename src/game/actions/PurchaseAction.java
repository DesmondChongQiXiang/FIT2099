package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;

/**
 * The PurchaseAction class represents the action of purchasing an item in the game.
 * It extends the Action class and works with items that implement the Purchasable interface.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class PurchaseAction extends Action {

    /**
     * The item to be purchased.
     */
    private final Purchasable purchasedItem;

    /**
     * The item's original purchase price.
     */
    private final int originalPrice;

    /**
     * Initializes a new PurchaseAction.
     *
     * @param purchasedItem The item to be purchased.
     * @param originalPrice the price of the item
     */
    public PurchaseAction(Purchasable purchasedItem, int originalPrice){
        this.purchasedItem = purchasedItem;
        this.originalPrice = originalPrice;
    }

    /**
     * Executes the purchase action.
     *
     * @param actor The actor performing the action.
     * @param map The game map where the action takes place.
     * @return A string describing the outcome of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return purchasedItem.purchasedBy(actor,originalPrice);
    }

    /**
     * Returns a description of the action that will be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string describing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s buys %s", actor, purchasedItem);
    }
}


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
    private final Purchasable item;

    /**
     * The item's original purchase price.
     */
    private final int originalPrice;

    /**
     * Initializes a new PurchaseAction.
     *
     * @param item The item to be purchased.
     * @param originalPrice the price of the item
     */
    public PurchaseAction(Purchasable item, int originalPrice){
        this.item = item;
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
        try{
            int finalPrice = item.purchasedBy(actor,this.originalPrice);
            return String.format("%s successfully purchased %s for %d runes.",actor, item, finalPrice);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    /**
     * Returns a description of the action that will be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string describing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s buys %s", actor,item);
    }
}


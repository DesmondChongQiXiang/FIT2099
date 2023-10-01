package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;

/**
 * The PurchaseAction class represents the action of purchasing an item in the game.
 * It extends the Action class and works with items that implement the Purchasable interface.
 */
public class PurchaseAction extends Action {
    /**
     * The item to be purchased.
     */
    private final Purchasable item;

    /**
     * Initializes a new PurchaseAction.
     *
     * @param buyer The actor who will be buying the item.
     * @param item The item to be purchased.
     */
    public PurchaseAction(Actor buyer, Purchasable item){
        this.item = item;
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
            int purchasePrice = item.purchasedBy(actor);
            return String.format("%s successfully purchased %s for %d runes.",actor, item, purchasePrice);
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


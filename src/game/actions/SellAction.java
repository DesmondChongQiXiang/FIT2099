package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import game.items.Sellable;

/**
 * The SellAction class represents the action of selling an item in the game.
 * It extends the Action class and works with items that implement the Sellable interface.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class SellAction extends Action {

    /**
     * The item to be sold.
     */
    private Sellable soldItem;

    /**
     * Initializes a new SellAction.
     *
     * @param soldItem The item to be sold.
     */
    public SellAction(Sellable soldItem) {
        this.soldItem = soldItem;
    }

    /**
     * Executes the sell action.
     *
     * @param actor The actor performing the action.
     * @param map The game map where the action takes place.
     * @return A string describing the outcome of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return soldItem.soldBy(actor);
    }

    /**
     * Returns a description of the action that will be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string describing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s sells %s", actor, soldItem);
    }
}

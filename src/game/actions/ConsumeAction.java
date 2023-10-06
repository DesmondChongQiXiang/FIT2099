package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * A class that represents the consume action for a Player, which can be done on all consumable items.
 * This action allows an actor to consume a consumable item, triggering its 'consumedBy' action.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class ConsumeAction extends Action {
    private final Consumable consumeItem;

    /**
     * Constructor.
     *
     * @param consumable the consumable item to be consumed
     */
    public ConsumeAction(Consumable consumable) {
        this.consumeItem = consumable;
    }

    /**
     * Executes the ConsumeAction.
     * It calls the 'consumedBy' action of the consumable item.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     *
     * @return The result string to be printed on the console.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumeItem.consumedBy(actor);
    }

    /**
     * Returns a description of this action suitable for display in the menu.
     *
     * @param actor The actor performing the action.
     *
     * @return A string to be printed on the menu, e.g., "Player consumes Health Potion".
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumeItem;
    }


}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * A class that represents the consume action for Player which can be done on all consumable items.
 *
 * @author Yoong Qian Xin
 */
public class ConsumeAction extends Action {
    private Consumable consumeItem;

    /**
     * Constructor.
     *
     * @param consumable the consumable item to be consumed
     */
    public ConsumeAction(Consumable consumable) {
      this.consumeItem = consumable;
    }

    /**
     * Execution of the ConsumeAction.
     * It will call the .consumedBy action of the consumable item.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     *
     * @return The result string to be printed on the console.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
      return this.consumeItem.consumedBy(actor);
    }

    /**
     * The action description to be printed on the menu to let the user choose.
     *
     * @param actor The actor performing the action.
     * @return The string to be printed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
      return actor + " consumes " + this.consumeItem;
    }


}

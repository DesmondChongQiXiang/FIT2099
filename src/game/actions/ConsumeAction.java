package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
/**
 * An Action that consume a consumable item
 */

public class ConsumeAction extends Action{
    /**
     * The target item that can be consumed
     */
    Consumable item;
    /**
     * Constructor to create an Action that will consume a consumable item
     *
     * @param item the target consumable item
     */
    public ConsumeAction(Consumable item){
        this.item = item;
    }

    /**
     * Allow the Actor to consume consumable item
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String ret = item.consume(actor);
        return ret;
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player consume HealingVial"
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s consumes %s",actor,item);
    }
}

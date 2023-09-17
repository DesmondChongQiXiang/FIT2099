package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.collections.RefreshingFlask;

/**
 * A custom Action class that represents an actor consuming a Refreshing Flask to restore stamina points.
 * This action allows an actor to use a Refreshing Flask to regain stamina points.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class ConsumeRefreshingFlaskAction extends Action {

    /**
     * The RefreshingFlask to be consumed.
     */
    private RefreshingFlask refreshingFlask;

    /**
     * Constructor for the ConsumeRefreshingFlaskAction class.
     *
     * @param refreshingFlask The RefreshingFlask to be consumed.
     */
    public ConsumeRefreshingFlaskAction(RefreshingFlask refreshingFlask) {
        this.refreshingFlask = refreshingFlask;
    }

    /**
     * Executes the consumption of the Refreshing Flask by the actor.
     *
     * @param actor The actor consuming the Refreshing Flask.
     * @param map   The GameMap on which the action is performed.
     * @return A string describing the outcome of consuming the Refreshing Flask.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int points = refreshingFlask.consume(actor);
        return String.format("%s consumes %s and %s restores the stamina of %s by %d points",actor,refreshingFlask,refreshingFlask,actor,points);
    }

    /**
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "Bob consumes Refreshing Flask").
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s consumes %s",actor,refreshingFlask);
    }
}

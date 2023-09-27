package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.*;

/**
 * The GreatSlamAction class represents an action where the player performs a "Great Slam" using a GiantHammer.
 * This action is executed on a target actor within a specific game map.
 *
 * @author Maliha Tariq
 */
public class GreatSlamAction extends Action {

    /**
     * The GiantHammer used to perform the Great Slam.
     */
    private final GiantHammer giantHammer;

    /**
     * The target actor on whom the Great Slam will be performed.
     */
    private final Actor targetActor;

    /**
     * The game map where the action takes place.
     */
    private final GameMap gameMap;

    /**
     * Constructor to initialize the GreatSlamAction.
     *
     * @param giantHammer The GiantHammer used for the action.
     * @param targetActor The target actor on whom the action will be performed.
     * @param gameMap The game map where the action takes place.
     */
    public GreatSlamAction(GiantHammer giantHammer, Actor targetActor, GameMap gameMap) {
        this.giantHammer = giantHammer;
        this.targetActor = targetActor;
        this.gameMap = gameMap;
    }

    /**
     * Executes the Great Slam action.
     *
     * @param actor The actor performing the action.
     * @param map The game map where the action takes place.
     * @return A string description of the action performed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        giantHammer.performGreatSlam(actor, targetActor, gameMap);
        return menuDescription(actor);
    }

    /**
     * Provides a menu description of the action.
     *
     * @param actor The actor performing the action.
     * @return A string description of the action for the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs Great Slam on " + targetActor;
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An Action that allows an actor to travel from one game map to another.
 * Use this to perform travel actions.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class TravelAction extends Action {

    /**
     * The target location
     */
    private final Location moveToLocation;

    /**
     * The name of the target map.
     */
    private final String mapName;

    /**
     * Constructor to create an Action that will make the actor travel from one game map to another.
     *
     * @param moveToLocation The location that the actor will be transferred to.
     * @param map        The name of the target map.
     */
    public TravelAction(Location moveToLocation, String map){
        this.moveToLocation = moveToLocation;
        this.mapName = map;
    }

    /**
     * Allow the Actor to travel
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, moveToLocation);
        return String.format("%s travelled to %s", actor, mapName);
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player travels to The Burial Ground"
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s travels to %s", actor, mapName);
    }


}

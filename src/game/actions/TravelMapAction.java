package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A custom Action class that represents an actor traveling to a specified location on the game map.
 * This action allows an actor to move from their current location to a destination location on the map.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class TravelMapAction extends Action {

    /**
     * The destination location where the actor will travel to.
     */
    private Location destination;

    /**
     * Constructor for the TravelMapAction class.
     *
     * @param location The destination location where the actor will travel to.
     */
    public TravelMapAction(Location location) {
        this.destination = location;
    }

    /**
     * Executes the travel action by moving the actor to the specified destination location on the map.
     *
     * @param actor The actor traveling to the destination.
     * @param map   The GameMap on which the action is performed.
     * @return A string describing the outcome of the travel action (e.g., "Bob traveled to the forest").
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, destination);
        return String.format("%s travelled to the %s",actor,destination.map());
    }

    /**
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "Bob travels to the forest").
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s travels to the %s",actor,destination.map());
    }
}

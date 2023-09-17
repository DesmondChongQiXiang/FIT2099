package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actions.Status;

/**
 * A behavior class representing the behavior of attacking other actors if they have the "ATTACKED_BY_ENEMY" status.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Retrieves the action for the actor to perform based on the attack behavior.
     *
     * @param wanderingUndeed The actor exhibiting the behavior.
     * @param map   The game map in which the actor is located.
     * @return An attack action if a suitable target is found; otherwise, null.
     */
    @Override
    public Action getAction(Actor wanderingUndeed, GameMap map) {
        if(!map.contains(wanderingUndeed))
            return null;

        Location attackerLocation = map.locationOf(wanderingUndeed);

        for (Exit exit : attackerLocation.getExits()) {
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.ATTACKED_BY_ENEMY)){
                return new AttackAction(exit.getDestination().getActor(), exit.getName());
            }
        }

        return null;
    }
}

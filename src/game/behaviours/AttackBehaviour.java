package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Status;
import game.actions.AttackAction;

/**
 * A class that figures out an AttackAction that will make the actor attack a target Actor.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Returns an AttackAction to nearby actor, if possible.
     * If no actor is nearby, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map   the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(destination.getActor(), exit.getName());
            }
        }
        return null;
    }


}

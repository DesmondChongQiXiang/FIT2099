package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Behaviour;

/**
 * A class that represents a wandering behavior for actors.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class WanderBehaviour implements Behaviour {

    private final Random random = new Random();

    /**
     * Returns a MoveAction to wander to a random location if possible.
     *
     * @param actor the Actor enacting the behaviour
     * @param map   the map that actor is currently on
     * @return a MoveAction, or null if no suitable action is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                actions.add(destination.getMoveAction(actor, "around", exit.getHotKey()));
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }
    }
}

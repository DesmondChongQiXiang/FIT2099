package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;
import game.items.Runes;

public abstract class FollowEnemy extends Enemy{

    public FollowEnemy(String name, char displayChar, int hitPoints, Runes runesDropped) {
        super(name, displayChar, hitPoints,runesDropped);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Determine the allowable actions that can be performed on this Forest Watcher.
     * Forest Watcher can follow actors with HOSTILE_TO_ENEMY capability and attack them.
     *
     * @param otherActor The Actor that might be performing an attack or action.
     * @param direction  A string representing the direction of the other Actor.
     * @param map        The current GameMap.
     * @return A list of actions that the Forest Watcher is allowed to execute or perform on the current actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add a FollowBehaviour to follow the hostile actor.
            this.behaviours.put(998, new FollowBehaviour(otherActor));
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}

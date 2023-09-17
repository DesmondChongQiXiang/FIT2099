package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actions.Status;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract base class for enemy actors in the game.
 * Enemy actors are non-playable characters that can perform various behaviors, such as attacking and wandering.
 * This class provides a framework for defining enemy behaviors and actions.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public abstract class Enemy extends Actor {

    /**
     * A map that associates behavior priorities with specific behaviours.
     */
    private Map<Integer, Behaviour> behaviours;

    /**
     * Constructor for the Enemy class.
     *
     * @param name        The name of the enemy.
     * @param displayChar The character representing the enemy in the game world.
     * @param hitPoints   The initial hit points of the enemy.
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours = new HashMap<>();
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(998, new AttackBehaviour());
    }

    /**
     * Gets the map of behaviors associated with their priorities.
     *
     * @return The map of behaviors.
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }

    /**
     * Overrides the default behavior for enemy actors during their turn.
     * The enemy evaluates its available behaviors and executes the highest-priority one.
     *
     * @param actions    The list of available actions.
     * @param lastAction The last executed action.
     * @param map        The game map on which the enemy is located.
     * @param display    The display object for rendering the game world.
     * @return The action to be executed during the enemy's turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Determines the allowable actions for the enemy when interacting with other actors.
     * The enemy can attack if the other actor has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor The other actor with which the enemy interacts.
     * @param direction  The direction from the enemy to the other actor.
     * @param map        The game map on which the interaction occurs.
     * @return A list of allowable actions based on the interaction context.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actionList.add(new AttackAction(this, direction));
        }
        return actionList;
    }

    /**
     * Handles the unconscious state of the enemy.
     * This method sets the enemy's health to 0, removes the enemy from the map, and triggers unconscious behavior.
     *
     * @param map The game map from which the enemy is removed.
     * @return A message indicating the outcome of the unconscious state.
     */
    @Override
    public String unconscious(GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE,0);
        new Display().println(new DoNothingAction().execute(this,map));
        map.removeActor(this);
        return super.unconscious(map);
    }
}

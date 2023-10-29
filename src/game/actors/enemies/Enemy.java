package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetNotifiableManager;
import game.reset.Resettable;
import game.actions.AttackAction;
import game.capabilities.Status;
import game.behaviours.AttackBehaviour;
import game.items.Runes;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class representing an enemy actor in the game.
 * Extends the Actor class and defines common behavior for enemy actors.
 *
 * Enemy actors are typically hostile and can perform various actions, including attacking and wandering.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Actor
 */
public abstract class Enemy extends Actor implements Resettable {
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    private Runes runesDropped;
    /**
     * Constructor for creating an enemy actor.
     *
     * @param name           The name of the enemy.
     * @param displayChar    Character to represent the enemy in the UI.
     * @param hitPoints      Enemy's starting number of hit points.
     * @param runesDropped The number of runes this enemy drops when defeated.
     */
    public Enemy(String name, char displayChar, int hitPoints, Runes runesDropped) {
        super(name, displayChar, hitPoints);

        // Priority of behavior:  1. AttackBehavior  2. FollowBehavior  3. WanderBehavior
        int firstPriority = 997;
        this.behaviours.put(firstPriority, new AttackBehaviour());

        // Add the ENEMY capability to mark this actor as an enemy.
        addCapability(Status.ENEMY);

        this.runesDropped = runesDropped;
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    Collection of possible Actions for this Actor.
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction().
     * @param map        The map containing the Actor.
     * @param display    The I/O object to which messages may be written.
     * @return The valid action that can be performed in that iteration or null if no valid action is found.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Method that can be executed when the enemy is unconscious due to the action of another actor.
     *
     * @param actor The perpetrator that caused the enemy to fall unconscious.
     * @param map   The GameMap where the enemy fell unconscious.
     * @return A string describing what happened when the enemy is unconscious.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.locationOf(this).addItem(runesDropped);
        ResetNotifiableManager.getInstance().registerResetNotifiable(runesDropped);
        return super.unconscious(actor, map);
    }

    /**
     * Determines the allowable actions that can be performed on this village-themed enemy.
     * Village enemies can be attacked by actors with the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor The Actor that might be performing an attack or action.
     * @param direction  A string representing the direction of the other Actor.
     * @param map        The current GameMap.
     * @return A list of actions that the enemy is allowed to execute or perform on the current actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    @Override
    public void reset(Location location) {
        location.map().removeActor(this);
    }
}


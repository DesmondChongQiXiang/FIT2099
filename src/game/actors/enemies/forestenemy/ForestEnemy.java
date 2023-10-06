package game.actors.enemies.forestenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;
import game.weathers.WeatherControllable;

/**
 * Abstract base class for enemies in a forest-themed game.
 * Extends the Enemy class and implements the WeatherControllable interface.
 *
 * This class provides a common base for all forest-themed enemy actors, defining their behavior and capabilities.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 * @see WeatherControllable
 */
public abstract class ForestEnemy extends Enemy implements WeatherControllable {
    /**
     * Constructor for creating a forest-themed enemy.
     *
     * @param name           The name of the enemy.
     * @param displayChar    The character used to display the enemy on the game map.
     * @param hitPoints      The initial hit points of the enemy.
     * @param runesNumDropped The number of runes this enemy drops when defeated.
     */
    public ForestEnemy(String name, char displayChar, int hitPoints, int runesNumDropped) {
        super(name, displayChar, hitPoints, runesNumDropped);
    }

    /**
     * Generates a list of allowable actions for this forest-themed enemy.
     * This method determines which actions the enemy can perform based on the presence of certain capabilities in other actors.
     *
     * @param otherActor The Actor that might be performing an attack or action.
     * @param direction  A string representing the direction of the other Actor.
     * @param map        The current GameMap.
     * @return A list of actions that the enemy is allowed to execute or perform on the current actor.
     */
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


package game.actors.enemies.villageenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;
import game.items.Runes;

/**
 * Abstract base class for village-themed enemies in the game.
 * Extends the Enemy class and defines common behavior for enemies found in villages.
 *
 * VillageEnemy represents enemies that can be attacked by actors with HOSTILE_TO_ENEMY capability.
 * These enemies typically have special characteristics and behaviors related to village settings.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 */
public abstract class VillageEnemy extends Enemy {
    /**
     * Constructor for creating a village-themed enemy.
     *
     * @param name           The name of the enemy.
     * @param displayChar    The character used to display the enemy on the game map.
     * @param hitPoints      The initial hit points of the enemy.
     * @param runesDropped The number of runes this enemy drops when defeated.
     */
    public VillageEnemy(String name, char displayChar, int hitPoints, Runes runesDropped) {
        super(name, displayChar, hitPoints, runesDropped);
        this.behaviours.put(999, new WanderBehaviour());
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
}

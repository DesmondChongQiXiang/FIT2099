package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.items.Runes;

/**
 * A class representing the Eldentree Guardian, a powerful enemy in the game.
 * Possesses the capability to enter the void and exhibits various behaviors including wandering and attacking hostile actors.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 */
public class EldentreeGuardian extends Enemy{

    /**
     * Constructor for the EldentreeGuardian class that initializes the attributes of the Eldentree Guardian.
     * Sets its name, display character, hit points, and runes.
     */
    public EldentreeGuardian() {
        super("Eldentree Guardian", 'e', 250, new Runes(250));
        this.addCapability(Ability.ENTER_VOID);
        int thirdPriority = 999;
        this.behaviours.put(thirdPriority, new WanderBehaviour());
    }


    /**
     * Retrieves the intrinsic weapon of the Eldentree Guardian.
     *
     * @return An intrinsic weapon representing the attack power and verb of the Eldentree Guardian.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(50, "attack", 80);
    }

    /**
     * Actions taken by the Eldentree Guardian when it becomes unconscious.
     * It has a chance to drop a Healing Vial and a Refreshing Flask upon being defeated.
     *
     * @param actor The actor interacting with the Eldentree Guardian.
     * @param map The current GameMap.
     * @return A string indicating the action taken when the Eldentree Guardian becomes unconscious.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        if (Math.random() <= 0.25) {
            map.locationOf(this).addItem(new HealingVial());
        }
        if (Math.random() <= 0.15) {
            map.locationOf(this).addItem(new RefreshingFlask());
        }
        return super.unconscious(actor, map);
    }

    /**
     * Determine the allowable actions that can be performed on this Forest Watcher.
     * Eldentree Guardian can follow actors with HOSTILE_TO_ENEMY capability and attack them.
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
            int secondPriority = 998;
            this.behaviours.put(secondPriority, new FollowBehaviour(otherActor));
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}

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
 * A class representing the Eldentree Guardian, an enemy character in the game.
 * The Eldentree Guardian is a powerful guardian protecting a specific location.
 */
public class EldentreeGuardian extends Enemy{

    /**
     * Constructor for the Eldentree Guardian.
     */
    public EldentreeGuardian() {
        super("Eldentree Guardian", 'e', 250, new Runes(250));
        this.addCapability(Ability.ENTER_VOID);
        int thirdPriority = 999;
        this.behaviours.put(thirdPriority, new WanderBehaviour());
    }

    /**
     * Get the intrinsic weapon of the Eldentree Guardian.
     *
     * @return An IntrinsicWeapon object representing the Guardian's attack capabilities.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(50, "attack", 80);
    }

    /**
     * Handle the unconscious state of the Eldentree Guardian.
     * This method is called when the guardian becomes unconscious, and it may drop items.
     *
     * @param actor The actor interacting with the guardian.
     * @param map The GameMap where the interaction occurs.
     * @return A String describing the outcome of the unconscious state.
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
     * Determine the allowable actions for the Eldentree Guardian when interacting with another actor.
     *
     * @param otherActor The other actor with which the guardian interacts.
     * @param direction The direction of interaction.
     * @param map The GameMap where the interaction occurs.
     * @return An ActionList containing allowable actions based on the guardian's behavior.
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

package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.items.BloodBerry;
import game.items.Runes;

/**
 * A class representing a Living Branch, an enemy actor in the game.
 * The Living Branch is a unique enemy that is associated with the game's world.
 */
public class LivingBranch extends Enemy {

    /**
     * Constructor for creating a Living Branch enemy actor.
     */
    public LivingBranch() {
        super("Living Branch", '?', 75, new Runes(500));
        this.addCapability(Ability.ENTER_VOID);
    }

    /**
     * Get the intrinsic weapon of the Living Branch.
     *
     * @return An IntrinsicWeapon object representing the Living Branch's attack capabilities.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(250, "attack", 90);
    }

    /**
     * Handle the unconscious state of the Living Branch. This method is called when the Living Branch becomes unconscious,
     * and it may drop items, such as BloodBerries.
     *
     * @param actor The actor interacting with the Living Branch.
     * @param map The GameMap where the interaction occurs.
     * @return A String describing the outcome of the unconscious state.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        if (Math.random() <= 0.50) {
            map.locationOf(this).addItem(new BloodBerry());
        }
        return super.unconscious(actor, map);
    }

    /**
     * Determine the allowable actions for the Living Branch when interacting with another actor.
     *
     * @param otherActor The other actor with which the Living Branch interacts.
     * @param direction The direction of interaction.
     * @param map The GameMap where the interaction occurs.
     * @return An ActionList containing allowable actions based on the Living Branch's behavior.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

}

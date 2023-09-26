package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Ability;
import game.items.Sellable;

/**
 * A class that represents the GiantHammer weapon
 */
public class GiantHammer extends WeaponItem implements Sellable {

    /**
     * Constructor.
     */
    public GiantHammer() {
        super("Giant Hammer", 'P', 160, "slams", 90);
        addCapability(Ability.HAS_SPECIAL_SKILL);
    }

    /**
     * List of allowable actions that the item can perform to the current actor.
     *
     * @param owner the actor that owns the item
     * @return a list of actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new SellAction(this));
        return actions;
    }

    /**
     * List of allowable actions that the item allows its owner do to another actor.
     * GiantHammer can return an attacking action to the other actor.
     *
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return a list of actions that contains an AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        // You might want to add another action here for the special “Great Slam” ability.
        return actions;
    }

    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 250;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    /**
     * Method to implement the special skill “Great Slam”
     * This will need interaction with other actors and may require additional modifications.
     */
    public void performGreatSlam(Actor actor, Location targetLocation) {
        // Implementation of the Great Slam, affecting the targeted enemy and surrounding actors.
        // This will likely require interaction with other classes and actors to fully implement.
    }
}

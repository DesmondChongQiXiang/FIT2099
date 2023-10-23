package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Ability;

/**
 * The `BloodBerry` class represents an item in the game called BloodBerry. BloodBerries can be consumed by actors
 * to increase their maximum health points. They are also sellable items. When consumed, a BloodBerry increases
 * the maximum health of the consuming actor by 5 points.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class BloodBerry extends Item implements Consumable,Sellable{

    /**
     * Constructor to create a BloodBerry item.
     */
    public BloodBerry() {
        super("BloodBerry", '*', true);
    }

    /**
     * Overrides the consumedBy method from the Consumable interface. Consuming a BloodBerry increases the maximum
     * health of the actor by 5 points and removes the BloodBerry from the actor's inventory.
     *
     * @param actor The actor consuming the BloodBerry.
     * @return A string describing the consumption action.
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 5);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s upgrade the maximum health of %s by 5 points", actor, this, this, actor);
    }

    /**
     * Overrides the allowableActions method for an owned item. BloodBerries can be consumed by the owner.
     *
     * @param owner The actor that owns the item.
     * @return A list of allowable actions for the owner actor.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Overrides the allowableActions method for an item that can be sold. BloodBerries can be sold by actors with
     * the buying capability.
     *
     * @param otherActor The actor performing the action.
     * @param location The location where the action takes place.
     * @return A list of allowable actions for other actors.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.BUYING)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Overrides the soldBy method from the Sellable interface. Selling a BloodBerry to an actor increases their balance
     * by 10 units, and the BloodBerry is removed from their inventory.
     *
     * @param seller The actor buying the BloodBerry.
     * @return The selling price of the BloodBerry (10 units).
     */
    @Override
    public String soldBy(Actor seller){
        int sellingPrice = 10;
        seller.addBalance(sellingPrice);
        seller.removeItemFromInventory(this);
        return String.format("%s sells %s for %d runes",seller, this,sellingPrice);
    }
}

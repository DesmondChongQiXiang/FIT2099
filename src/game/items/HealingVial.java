package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Ability;


/**
 * A class that represents a Healing Vial that can increase the health of an actor.
 * Created by:
 * Modified by:
 */
public class HealingVial extends Item implements Consumable,Purchasable,Sellable {

    /**
     * Constructor.
     */
    public HealingVial() {
        super("Healing Vial", 'a', true);
    }

    /**
     * Each time the player uses it, their health will increase by 10% of their maximum health points.
     * It can only be consumed once by the player and cannot be consumed directly from the ground.
     * They must be picked up by the player before being consumed.
     *
     * @param actor the actor who owns the HealingVial item
     * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
     */
    @Override
    public String consumedBy(Actor actor){
        int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.HEALTH);
        int healingPoints = maxStamina / 10;
        actor.heal(healingPoints);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s restores the health of %s by %d points",actor,this,this,actor, healingPoints);
    }

    /**
     * List of allowable actions that the Healing Vial can perform on the current actor.
     * The Player can perform ConsumeAction on HealingVial.
     *
     * @param owner the actor that owns the item
     * @return a list of Actions for actor acts on the HealingVial item
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Returns the allowable actions that can be performed with this item.
     *
     * @param otherActor The actor performing the action.
     * @param location   The location where the action takes place.
     * @return A list of allowable actions.
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
     * Handles the purchase of the HealingVial by an actor.
     *
     * @param buyer         The actor buying the item.
     * @param purchasePrice The purchase price of the item.
     * @return The price at which the item was purchased.
     * @throws IllegalStateException if the buyer's balance is insufficient.
     */
    @Override
    public int purchasedBy(Actor buyer, int purchasePrice) {
        if (Math.random() <= 0.25){
            purchasePrice = purchasePrice + (int)(purchasePrice * 0.5f);
        }
        if (buyer.getBalance() < purchasePrice){
            throw new IllegalStateException(String.format("%s's balance is insufficient.", buyer));
        }
        else{
            buyer.deductBalance(purchasePrice);
            buyer.addItemToInventory(this);
        }
        return purchasePrice;
    }

    /**
     * Handles the sale of the HealingVial by an actor.
     *
     * @param actor The actor selling the item.
     * @return The price at which the item was sold.
     */
    @Override
    public int soldBy(Actor actor){
        int sellingPrice = 0;
        if(Math.random() <= 0.10){
            sellingPrice = 35*2;
            actor.addBalance(sellingPrice);
        }
        else{
            sellingPrice = 35;
            actor.addBalance(sellingPrice);
        }
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

}

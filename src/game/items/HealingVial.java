package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.actions.UpgradeAction;
import game.capabilities.Ability;


/**
 * The HealingVial class represents an item in the game that can be consumed by an actor to increase their health.
 * It extends the Item class and implements the Consumable, Purchasable, and Sellable interfaces.
 *
 * When consumed, the HealingVial restores 10% of the actor's maximum health points and is removed from the actor's inventory.
 * It can also be purchased and sold by actors.
 *
 * @author MA_AppliedSession1_Group7
 *
 * @see Item
 * @see Consumable
 * @see Purchasable
 * @see Sellable
 */
public class HealingVial extends Item implements Consumable, Purchasable, Sellable, Upgradable {

    private boolean isUpgraded;
    private double hitPointUpgradeRate;
    /**
     * Constructor to create a HealingVial item.
     */
    public HealingVial() {
        super("Healing Vial", 'a', true);
        this.isUpgraded = false;
        this.hitPointUpgradeRate = 0.1;
    }

    /**
     * Restores 10% of the actor's maximum health points when consumed and removes the HealingVial from the actor's inventory.
     *
     * @param actor The actor who consumes the HealingVial.
     * @return A description of what happened after consumption.
     */
    @Override
    public String consumedBy(Actor actor) {
        int healingPoints =  (int)(actor.getAttributeMaximum(BaseActorAttributes.HEALTH) * hitPointUpgradeRate);
        actor.heal(healingPoints);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and restores %s health by %d points", actor, this, actor, healingPoints);
    }

    /**
     * Returns a list of allowable actions for the owner of the HealingVial item, which includes the ConsumeAction.
     *
     * @param owner The actor who owns the item.
     * @return A list of allowable actions for the actor.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Returns a list of allowable actions for other actors interacting with the HealingVial, including the SellAction.
     *
     * @param otherActor The actor performing the action.
     * @param location   The location where the action takes place.
     * @return A list of allowable actions for the actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.BUYING)) {
            actions.add(new SellAction(this));
        }
        if (!isUpgraded && otherActor.hasCapability(Ability.UPGRADE_EQUIPMENT)){
            actions.add(new UpgradeAction(this));
        }
        return actions;
    }

    /**
     * Handles the purchase of the HealingVial by an actor.
     * Adjusts the purchase price based on a random chance and deducts the price from the buyer's balance.
     *
     * @param buyer         The actor buying the item.
     * @param purchasePrice The purchase price of the item.
     * @return The adjusted price at which the item was purchased.
     * @throws IllegalStateException if the buyer's balance is insufficient.
     */
    @Override
    public String purchasedBy(Actor buyer, int purchasePrice) {
        if (Math.random() <= 0.25) {
            purchasePrice = purchasePrice + (int) (purchasePrice * 0.5f);
        }
        if (buyer.getBalance() < purchasePrice) {
            return (String.format("%s's balance is insufficient.", buyer));
        } else {
            buyer.deductBalance(purchasePrice);
            buyer.addItemToInventory(this);
        }
        return String.format("%s successfully purchased %s for %d runes.",buyer, this, purchasePrice);
    }

    /**
     * Handles the sale of the HealingVial by an seller.
     * Adjusts the selling price based on a random chance and adds the price to the seller's balance.
     *
     * @param seller The seller selling the item.
     * @return The adjusted price at which the item was sold.
     */
    @Override
    public String soldBy(Actor seller) {
        int sellingPrice = 35;
        if (Math.random() <= 0.10) {
            sellingPrice = 35 * 2;
        }
        seller.addBalance(sellingPrice);
        seller.removeItemFromInventory(this);
        return String.format("%s sells %s for %d runes",seller, this,sellingPrice);
    }

    /**
     * Upgrades the HealingVial to improve its effectiveness.
     *
     * @param upgrader The actor who is upgrading the HealingVial.
     * @return A message indicating the result of the upgrade, including success or insufficient balance.
     */
    @Override
    public String upgrade(Actor upgrader) {
        int upgradePrice = 250;
        if (upgrader.getBalance() < upgradePrice) {
            return String.format("%s's balance is insufficient.", upgrader);
        } else {
            isUpgraded = true;
            hitPointUpgradeRate = 0.8;
            upgrader.deductBalance(upgradePrice);
        }
        return String.format("%s's effectiveness has been improved!",this);
    }
}


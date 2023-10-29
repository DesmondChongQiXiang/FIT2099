package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.actions.UpgradeAction;
import game.capabilities.Ability;

/**
 * A class that represents a Refreshing Flask item in the game.
 *
 * The Refreshing Flask is a consumable item that can be used by actors to increase their stamina.
 * It can also be bought and sold in the game.
 *
 * @author MA_AppliedSession1_Group7
 */
public class RefreshingFlask extends Item implements Consumable, Sellable, Purchasable, Upgradable{

    private boolean isUpgraded;
    private double staminaUpgradeRate;
    /**
     * Constructor for the RefreshingFlask class.
     * Initializes the Refreshing Flask with its name, display character, and the fact that it is transferable (can be carried by actors).
     */
    public RefreshingFlask(){
        super("Refreshing Flask", 'u', true);
        this.isUpgraded = false;
        this.staminaUpgradeRate = 0.2;
    }

    /**
     * Increases the actor's stamina by 20% of their maximum stamina when consumed.
     * The item is removed from the actor's inventory after consumption.
     *
     * @param actor The actor who consumes the Refreshing Flask.
     * @return A description of the consumption action and its effects.
     */
    @Override
    public String consumedBy(Actor actor) {;
        int rewardStamina = (int)(actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * staminaUpgradeRate);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, rewardStamina);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s restores the stamina of %s by %d points",actor,this,this,actor, rewardStamina);
    }

    /**
     * Returns a list of allowable actions that can be performed on this Refreshing Flask by the owner actor.
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
     * Returns a list of allowable actions that can be performed with this Refreshing Flask by other actors at a specific location.
     *
     * @param otherActor The actor performing the action.
     * @param location The location where the action takes place.
     * @return A list of allowable actions for other actors at the specified location.
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
     * Sells the Refreshing Flask to an actor and calculates the selling price.
     *
     * @param seller The actor to whom the item is sold.
     * @return The selling price of the Refreshing Flask.
     */
    @Override
    public String soldBy(Actor seller){
        int sellingPrice = 0;
        if (Math.random() <= 0.5){
            sellingPrice = 25;
            seller.addBalance(sellingPrice);
            return String.format("%s sells %s for %d runes",seller, this,sellingPrice);
        }
        seller.removeItemFromInventory(this);
        return String.format("Seller rob " + seller +" of his " + this + " without giving runes");
    }

    /**
     * Purchases the Refreshing Flask by an actor and deducts the purchase price from their balance.
     *
     * @param buyer The actor buying the item.
     * @param purchasePrice The price at which the item is purchased.
     * @return The actual purchase price after possible discounts.
     * @throws IllegalStateException If the buyer's balance is insufficient for the purchase.
     */
    @Override
    public String purchasedBy(Actor buyer, int purchasePrice) {
        if (Math.random() <= 0.1){
            purchasePrice = purchasePrice - (int)(purchasePrice * 0.2f);
        }
        if (buyer.getBalance() < purchasePrice){
            return String.format("%s's balance is insufficient.", buyer);
        }
        else{
            buyer.deductBalance(purchasePrice);
            buyer.addItemToInventory(this);
        }
        return String.format("%s successfully purchased %s for %d runes.",buyer, this, purchasePrice);
    }

    /**
     * Upgrades the Refreshing Flask to improve its effectiveness.
     *
     * @param upgrader The actor who is upgrading the Refreshing Flask.
     * @return A message indicating the result of the upgrade, including success or insufficient balance.
     */
    @Override
    public String upgrade(Actor upgrader) {
        int upgradePrice = 175;
        if (upgrader.getBalance() < upgradePrice) {
            return String.format("%s's balance is insufficient.", upgrader);
        } else {
            isUpgraded = true;
            staminaUpgradeRate = 1;
            upgrader.deductBalance(upgradePrice);
        }
        return String.format("%s's effectiveness has been improved!",this);
    }
}

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
 * A class that represents Refreshing Flask that can increase the stamina of an actor.
 */
public class RefreshingFlask extends Item implements Consumable, Sellable, Purchasable{
    /**
     * Constructor.
     */
    public RefreshingFlask(){
        super("Refreshing Flask", 'u', true);
    }

    /**
     * Each time the player uses it, their stamina will increase by 20% of their maximum stamina.
     * It can only be consumed once by the player and cannot be consumed directly from the ground.
     * They must be picked up by the player before being consumed.
     *
     * @param actor the actor who owns the RefreshingFlask item
     *
     * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
     */
    @Override
    public String consumedBy(Actor actor) {
        int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.STAMINA);
        int rewardStamina = maxStamina / 5;
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, rewardStamina);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s restores the stamina of %s by %d points",actor,this,this,actor, rewardStamina);
    }

    /**
     * List of allowable actions that the Refreshing Flask can perform to the current actor.
     * The Player can perform ConsumeAction on RefreshingFlask.
     *
     * @param owner the actor that owns the item
     *
     * @return a list of Actions for actor acts on the RefreshingFlask item
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Returns the allowable actions that can be performed with this weapon.
     *
     * @param otherActor The actor performing the action.
     * @param location The location where the action takes place.
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

    @Override
    public int soldBy(Actor actor){
        int sellingPrice = 0;
        if (Math.random() <= 0.5){
            sellingPrice = 25;
            actor.addBalance(sellingPrice);
        }
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    @Override
    public int purchasedBy(Actor buyer, int purchasePrice) {
        if (Math.random() <= 0.1){
            purchasePrice = purchasePrice - (int)(purchasePrice * 0.2f);
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
}

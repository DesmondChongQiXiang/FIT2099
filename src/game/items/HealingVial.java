package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * A class that represents HealingVial that can increase the health of an actor.
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
     *
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
     * List of allowable actions that the Healing Vial can perform to the current actor.
     * The Player can perform ConsumeAction on HealingVial.
     *
     * @param owner the actor that owns the item
     *
     * @return a list of Actions for actor acts on the HealingVials item
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void purchasedBy(Actor actor) {
        int purchasePrice = 0;
        if (Math.random() <= 0.25){
            purchasePrice = 100 + (int)(100 * 0.5f);
        }
        else{
            purchasePrice = 100;
        }
        if (actor.getBalance() < purchasePrice){
            throw new IllegalStateException(String.format("%s's balance is insufficient.", actor));
        }
        else{
            actor.deductBalance(purchasePrice);
            actor.addItemToInventory(this);
        }
    }

    @Override
    public void soldBy(Actor actor){
        if(Math.random() <= 0.10){
            actor.addBalance(35*2);
        }
        else{
            actor.addBalance(35);
        }
        actor.removeItemFromInventory(this);
    }
}

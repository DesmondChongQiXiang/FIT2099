package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ActivateSkillAction;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Status;
import game.items.Purchasable;
import game.items.Sellable;
import game.actions.ActiveSkill;

/**
 * The GreatKnife class represents a specialized weapon in the game world.
 * It extends the WeaponItem class and implements the Sellable, Purchasable, and ActiveSkill interfaces.
 * This weapon has unique capabilities and actions, including a special skill.
 *
 * @author Maliha Tariq
 * Modified by: Desmond Chong
 */
public class GreatKnife extends WeaponItem implements Sellable, Purchasable, ActiveSkill {
    /**
     * Constructor to initialize the GreatKnife weapon.
     */
    public GreatKnife() {
        super("Great Knife", '>', 75, "stabs", 70);

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
     * GreatKnife can return an attacking action to the other actor.
     *
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return a list of actions that contains an AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.ENEMY)) {
            actions.add(new AttackAction(otherActor, location.toString(), this));
            actions.add(new ActivateSkillAction(this,otherActor));
        }
        return actions;
    }

    /**
     * Handles the purchase of the GreatKnife by an actor.
     *
     * @param buyer The actor attempting to purchase the item.
     * @return The purchase price of the item.
     * @throws IllegalStateException if the actor's balance is insufficient.
     */
    @Override
    public int purchasedBy(Actor buyer) {
        int purchasePrice = 300;
        if (Math.random() <= 0.05){
            purchasePrice *= 3;
        }
        if (buyer.getBalance() - purchasePrice < 0){
            throw new IllegalStateException("Player's balance is insufficient");
        }
        else {
            buyer.deductBalance(purchasePrice);
            buyer.addItemToInventory(this);
            return purchasePrice;
        }
    }

    /**
     * Handles the logic for selling the item by an actor.
     * The actor's balance is increased by the selling price of the item.
     * There is a 10% chance that the traveller will take the runes instead of paying.
     * The item is then removed from the actor's inventory.
     *
     * @param actor The actor who is selling the item.
     * @return The selling price of the item.
     */
    @Override
    public int soldBy(Actor actor) {
        int soldPrice = 175;
        if (Math.random() <= 0.1){// 10% chance that the traveller takes the runes instead
            if (actor.getBalance() < soldPrice){
                actor.deductBalance(actor.getBalance());
            }
            else{
                actor.deductBalance(soldPrice);
                throw new IllegalStateException("Seller rob " + actor +" of his runes");
            }
        }
        else{
            actor.addBalance(soldPrice);
        }
        actor.removeItemFromInventory(this);
        return soldPrice;
    }

    /**
     * Activates the special skill of the weapon when used by an actor.
     *
     * @param owner         The actor who is activating the skill.
     * @param target         The target actor who will be affected by the skill.
     * @param map           The map that processing this action
     * @return A string describing the outcome of activating the skill.
     */
    @Override
    public String activateSkill(Actor owner, Actor target, GameMap map) {
        try{
            staminaConsumedByActivateSkill(owner);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return skillAction(owner,target,map);
    }

    /**
     * Consumes stamina when the special skill is activated.
     *
     * @param owner The actor activating the skill.
     */
    @Override
    public void staminaConsumedByActivateSkill(Actor owner) {
        int staminaCost = (int)(owner.getAttributeMaximum(BaseActorAttributes.STAMINA) * 0.25f);

        // Check if the actor has enough stamina
        if (owner.getAttribute(BaseActorAttributes.STAMINA) <= staminaCost) {
            throw new IllegalStateException(owner + " doesn't have enough stamina to use the special skill!");
        }
        else {
            owner.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        }
    }

    /**
     * Selects an exit location for the actor to move to.
     *
     * @param actor The actor to move.
     * @param map The game map.
     * @return The new location for the actor.
     * @throws IllegalStateException if no suitable exit is found.
     */
    private Location selectExit(Actor actor, GameMap map){
        Location currentLocation = map.locationOf(actor);

        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor) && destination.canActorEnter(actor)) {
                return destination;
            }
        }
        throw new IllegalStateException(String.format("%s fails to step away",actor));
    }

    /**
     * Executes the skill action, which includes attacking and potentially moving the actor.
     *
     * @param owner The actor activating the skill.
     * @param target The target actor.
     * @param map The game map.
     * @return A string describing the outcome.
     */
    @Override
    public String skillAction(Actor owner, Actor target, GameMap map) {
        String ret = new AttackAction(target,map.locationOf(target).toString(),this).execute(owner,map);
        try {
            Location exit = selectExit(owner, map);
            ret += "\n" + new MoveActorAction(exit,("to " + exit)).execute(owner,map);
        }
        catch(Exception e){
            ret += "\n" + e.getMessage();
        }
        return ret;
    }
}


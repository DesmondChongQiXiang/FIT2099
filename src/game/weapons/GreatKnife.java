package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Ability;
import game.items.Purchasable;
import game.items.Sellable;

import java.util.List;
import java.util.Random;

/**
 * A class that represents the GreatKnife weapon
 */
public class GreatKnife extends WeaponItem implements Sellable, Purchasable, WeaponSkill {

    /**
     * Constructor.
     */
    public GreatKnife() {
        super("Great Knife", '>', 75, "stabs", 70);
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
     * GreatKnife can return an attacking action to the other actor.
     *
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return a list of actions that contains an AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }

    @Override
    public int purchasedBy(Actor actor) {
        int purchasePrice = 300;
        if (actor.getBalance() < purchasePrice) {
            throw new IllegalStateException("Player's balance is insufficient");
        } else {
            if (Math.random() <= 0.05) { // 5% chance that the price will be tripled
                int tripledPrice = purchasePrice * 3;
                if (actor.getBalance() < tripledPrice) {
                    throw new IllegalStateException("Player's balance is insufficient for the tripled price");
                }
                actor.deductBalance(tripledPrice);
            } else {
                actor.deductBalance(purchasePrice);
            }
            actor.addItemToInventory(this);
        }
        return purchasePrice;
    }

    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 175;
        actor.addBalance(sellingPrice);
        if (Math.random() <= 0.10) { // 10% chance that the traveller takes the runes instead
            actor.deductBalance(sellingPrice);
        }
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    @Override
    public String activateSkill(Actor actor, Actor target) {  // target is now a parameter
        int staminaCost = calculateStaminaCost(actor);

        if (!hasEnoughStamina(actor, staminaCost)) {
            return actor + " doesn't have enough stamina to use the special skill!";
        }

        dealDamageToTarget(target);

        Location newLocation = findNewLocation(actor);
        if (newLocation != null) {
            moveActorToNewLocation(actor, newLocation);
        }

        reduceActorStamina(actor, staminaCost);

        return actor + " stabbed " + target + " and stepped away to safety!";
    }

    private int calculateStaminaCost(Actor actor) {
        return actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * 25 / 100;
    }

    private boolean hasEnoughStamina(Actor actor, int staminaCost) {
        return actor.getAttribute(BaseActorAttributes.STAMINA) >= staminaCost;
    }

    private void dealDamageToTarget(Actor target) {
        int damage = 75;
        target.hurt(damage);
    }

    private void moveActorToNewLocation(Actor actor, Location newLocation) {
        actor.setLocation(newLocation);
    }

    private void reduceActorStamina(Actor actor, int staminaCost) {
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
    }



    public Location findNewLocation(Actor actor) {
        Location currentLocation = actor.locationOf(actor); // assuming locationOf is a method in Actor class
        List<Exit> exits = currentLocation.getExits();

        // Additional logic to select a new location from exits
        for (Exit exit : exits) {
            Location newLocation = exit.getDestination();
            if (newLocation.canActorEnter(actor)) {
                return newLocation; // Return the new location found
            }
        }
        return null; // Return null if no valid new location is found
    }

    public void setLocation(Actor actor, Location newLocation, ActorLocationsIterator actorLocations) {
        if (actorLocations.contains(actor)) {
            actorLocations.move(actor, newLocation); // Move actor to newLocation if actor already exists in actorLocations
        } else {
            actorLocations.add(actor, newLocation); // Add actor to newLocation if actor does not exist in actorLocations
        }
    }

}

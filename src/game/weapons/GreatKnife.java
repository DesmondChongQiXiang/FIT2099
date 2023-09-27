package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ActivateSkillAction;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Ability;
import game.items.Purchasable;
import game.items.Sellable;
import game.actions.ActiveSkill;

import java.util.List;

/**
 * The GreatKnife class represents a specialized weapon in the game world.
 * It extends the WeaponItem class and implements the Sellable, Purchasable, and ActiveSkill interfaces.
 * This weapon has unique capabilities and actions, including a special skill.
 *
 * @author Maliha Tariq
 */
public class GreatKnife extends WeaponItem implements Sellable, Purchasable, ActiveSkill {

    private GameMap gameMap;

    /**
     * Constructor to initialize the GreatKnife weapon.
     */
    public GreatKnife(GameMap gameMap) {
        super("Great Knife", '>', 75, "stabs", 70);
        this.gameMap = gameMap;
        addCapability(Ability.HAS_SPECIAL_SKILL);
        addCapability(Ability.GREAT_KNIFE);  // Unique capability

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
        actions.add(new ActivateSkillAction(this));
        return actions;
    }

    /**
     * Handles the purchase of the GreatKnife by an actor.
     *
     * @param actor The actor attempting to purchase the item.
     * @return The purchase price of the item.
     * @throws IllegalStateException if the actor's balance is insufficient.
     */
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
        int sellingPrice = 175;
        actor.addBalance(sellingPrice);
        if (Math.random() <= 0.10) { // 10% chance that the traveller takes the runes instead
            actor.deductBalance(sellingPrice);
        }
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    /**
     * Activates the special skill of the weapon when used by an actor.
     *
     * @param actor          The actor who is activating the skill.
     * @param target         The target actor who will be affected by the skill.
     * @param actorLocations The actor locations iterator for moving the actor.
     * @return A string describing the outcome of activating the skill.
     */
    @Override
    public String activateSkill(Actor actor, Actor target, ActorLocationsIterator actorLocations) {
        // Check if the actor has enough stamina
        if (!checkAndCalculateStamina(actor)) {
            return actor + " doesn't have enough stamina to use the special skill!";
        }

        // Deal damage to the target
        dealDamageToTarget(target);

        // Find and move to a new location
        boolean moved = findAndSetNewLocation(actor, actorLocations);
        if (!moved) {
            return actor + " couldn't find a new location to move to!";
        }

        // Reduce actor's stamina
        int staminaCost = actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * 25 / 100;
        reduceActorStamina(actor, staminaCost);

        return actor + " stabbed " + target + " and stepped away to safety!";
    }


    /**
     * Checks if the actor has enough stamina for the special skill and calculates the cost.
     *
     * @param actor The actor using the skill.
     * @return True if the actor has enough stamina, false otherwise.
     */
    private boolean checkAndCalculateStamina(Actor actor) {
        int staminaCost = actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * 25 / 100;
        return actor.getAttribute(BaseActorAttributes.STAMINA) >= staminaCost;
    }

    /**
     * Deals a fixed amount of damage to the target actor.
     *
     * @param target The actor to be damaged.
     */
    private void dealDamageToTarget(Actor target) {
        int damage = 75;
        target.hurt(damage);
    }

    /**
     * Reduces the stamina of the actor by a specified amount.
     *
     * @param actor       The actor whose stamina will be reduced.
     * @param staminaCost The amount by which the actor's stamina will be reduced.
     */
    private void reduceActorStamina(Actor actor, int staminaCost) {
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
    }


    /**
     * Finds a new location for the actor and sets it.
     *
     * @param actor The actor to move.
     * @param actorLocations The locations of all actors.
     * @return True if the actor was successfully moved, false otherwise.
     */
    private boolean findAndSetNewLocation(Actor actor, ActorLocationsIterator actorLocations) {
        Location currentLocation = this.gameMap.locationOf(actor);
        List<Exit> exits = currentLocation.getExits();

        for (Exit exit : exits) {
            Location newLocation = exit.getDestination();
            if (newLocation.canActorEnter(actor)) {
                if (actorLocations.contains(actor)) {
                    actorLocations.move(actor, newLocation);
                } else {
                    actorLocations.add(actor, newLocation);
                }
                return true;
            }
        }
        return false;
    }


}

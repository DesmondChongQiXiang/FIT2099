package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ActivateSkillAction;
import game.actions.ActiveSkill;
import game.actions.AttackAction;
import game.capabilities.Status;
import game.items.Sellable;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Exit;

/**
 * The GiantHammer class represents a specialized weapon item that has unique actions and abilities.
 * It extends the WeaponItem class and implements the Sellable & ActiveSkill interface.
 *
 * @author Maliha Tariq
 * Modified By: Desmond Chong
 */
public class GiantHammer extends WeaponItem implements Sellable, ActiveSkill {
    /**
     * Constructor to initialize the GiantHammer.
     */
    public GiantHammer() {
        super("Giant Hammer", 'P', 160, "slams", 90);
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
        if (otherActor.hasCapability(Status.ENEMY)) {
            actions.add(new AttackAction(otherActor, location.toString(), this));
            actions.add(new ActivateSkillAction(this,otherActor));
        }
        return actions;
    }

    /**
     * Defines the selling process of the GiantHammer.
     *
     * @param actor The actor selling the item.
     * @return The selling price of the item.
     */
    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 250;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    /**
     * Activates the special skill of the GiantHammer.
     *
     * @param owner The actor owning the weapon.
     * @param target The target actor.
     * @param map The game map.
     * @return A string describing the outcome of the skill activation.
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
     * @param owner The actor owning the weapon.
     */
    @Override
    public void staminaConsumedByActivateSkill(Actor owner) {
        int staminaCost = (int)(owner.getAttributeMaximum(BaseActorAttributes.STAMINA) * 0.05f);

        // Checks if the actor has enough stamina
        if (owner.getAttribute(BaseActorAttributes.STAMINA) <= staminaCost) {
            throw new IllegalStateException(owner + " doesn't have enough stamina to use the special skill!");
        }
        else {
            owner.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        }
    }

    /**
     * Executes the skill action.
     *
     * @param owner The actor owning the weapon.
     * @param target The target actor.
     * @param map The game map.
     * @return A string describing the outcome of the skill action.
     */
    @Override
    public String skillAction(Actor owner, Actor target, GameMap map) {
        String ret = new AttackAction(target,map.locationOf(target).toString(),this).execute(owner,map);

        this.updateDamageMultiplier(0.5f);
        Location currentLocation = map.locationOf(owner);

        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.ENEMY)){
                ret += "\n" + new AttackAction(destination.getActor(), map.locationOf(destination.getActor()).toString(),this).execute(owner,map);
            }
        }
        ret += "\n" + new AttackAction(owner,map.locationOf(owner).toString(),this).execute(owner,map);
        this.updateDamageMultiplier(1.0f);
        return ret;
    }
}

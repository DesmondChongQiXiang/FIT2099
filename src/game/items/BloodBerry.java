package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ActivateSkillAction;
import game.actions.AttackAction;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Ability;
import game.capabilities.Status;

public class BloodBerry extends Item implements Consumable,Sellable{

    /***
     * Constructor.
     */
    public BloodBerry() {
        super("BloodBerry", '*', true);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 5);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s upgrade the maximum health of %s by 5 points", actor, this, this, actor);
    }

    /**
     * List of allowable actions that the Blood Berry can perform to the current actor.
     * The Player can perform ConsumeAction on Blood Berry.
     *
     * @param owner the actor that owns the item
     *
     * @return a list of Actions for actor acts on the Blood Berry item
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
        int sellingPrice = 10;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }
}

package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
/**
 * A class that represents HealingVial that can increase the health of an actor.
 */
public class HealingVial extends Item implements Consumable {
    /**
     * Constructor.
     */
    public HealingVial() {
        super("Healing Vial", 'a', true);
    }

    /**
     * increase the health of an actor after consume HealingVial
     * Remove the healing vial from actor inventory after consume it
     *
     * @param actor the Actor consume the Healing Vial
     * @return a String that describe the action of consume healing vial done by an actor
     */
    @Override
    public String consume(Actor actor){
        int healthPointsIncrease = (int)(actor.getAttributeMaximum(BaseActorAttributes.HEALTH) * .1f);
        actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE,healthPointsIncrease);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s restores the health of %s by %d points",actor,this,this,actor,healthPointsIncrease);
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     * a healing vial can have a special skill that can increase the current actor's hitpoints.
     *
     * @param owner the actor that owns the item
     * @return an list of Actions that contain ConsumeAction
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}

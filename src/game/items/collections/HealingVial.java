package game.items.collections;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeHealingVialAction;

/**
 * A class representing a healing vial item in the game.
 * Healing vials can be consumed by players to restore health.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class HealingVial extends Item implements Consumable {

    /**
     * A class representing a healing vial item in the game.
     * Healing vials can be consumed by actors to restore health.
     */
    public HealingVial(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * Returns a list of allowable actions when interacting with this healing vial.
     *
     * @param owner The actor interacting with the healing vial.
     * @return An ActionList containing the ConsumeHealingVialAction.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeHealingVialAction(this));
        return actionList;
    }

    /**
     * Returns a string representation of the healing vial.
     *
     * @return A string representing the healing vial.
     */
    public String toString(){
        return "Healing Vial";
    }

    /**
     * Consumes the healing vial, healing the actor and removing it from their inventory.
     *
     * @param actor The actor consuming the healing vial.
     * @return The amount of health restored to the actor.
     */
    @Override
    public int consume(Actor actor) {
        actor.heal((int)(actor.getAttributeMaximum(BaseActorAttributes.HEALTH)*0.1f));
        actor.removeItemFromInventory(this);
        return (int)(actor.getAttributeMaximum(BaseActorAttributes.HEALTH)*0.1f);
    }
}

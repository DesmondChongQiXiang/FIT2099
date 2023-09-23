package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
/**
 * A class that represents Refreshing Flask that can increase the stamina of an actor.
 */
public class RefreshingFlask extends Item implements Consumable {
    /**
     * Constructor.
     */
    public RefreshingFlask(){
        super("Refreshing Flask", 'u', true);
    }

    /**
     * increase the stamina of an actor after consume Refreshing Flask
     * Remove the Refreshing Flask from actor inventory after consume it
     *
     * @param actor the Actor consume the Refreshing Flask
     * @return a String that describe the action of consume Refreshing Flask done by an actor
     */
    @Override
    public String consume(Actor actor) {
        int staminaIncrease = (int)(actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * .2f);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE,staminaIncrease);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes %s and %s restores the stamina of %s by %d points",actor,this,this,actor,staminaIncrease);
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     * a refreshing flask can have a special skill that can increase the current actor's stamina.
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

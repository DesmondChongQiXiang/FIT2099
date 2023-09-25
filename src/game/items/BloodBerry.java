package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class BloodBerry extends Item implements Consumable {

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

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

}

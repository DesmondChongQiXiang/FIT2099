package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.actions.SellAction;

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

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        actions.add(new SellAction(this));
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

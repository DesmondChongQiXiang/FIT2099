package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class Runes extends Item implements Consumable {

    private int amount;

    public Runes(int amount) {
        super("Runes", '$', true);
        this.amount = amount;
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.addBalance(amount);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes Runes",actor) ;
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

}

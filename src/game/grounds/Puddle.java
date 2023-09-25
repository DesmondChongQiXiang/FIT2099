package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.items.Consumable;

public class Puddle extends Ground implements Consumable {
    /**
     * Constructor.
     */
    public Puddle() {
        super('~');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1);
        int rewardStamina = (int)((actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * .01f));
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, rewardStamina);
        return String.format("%s drinks from the water puddle. They feel refreshed.",actor) ;
    }
    @Override
    public String toString(){
        return "Water Puddle";
    }
}

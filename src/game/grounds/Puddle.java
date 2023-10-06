package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.items.Consumable;

/**
 * The `Puddle` class represents a puddle of water on the ground in the game. It is a type of ground environment
 * represented by the character '~' on the game map and is also a `Consumable` item.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Puddle extends Ground implements Consumable {
    /**
     * Constructor to create a `Puddle` instance. It is represented by the character '~'.
     */
    public Puddle() {
        super('~');
    }

    /**
     * Returns a list of allowable actions for an actor at this puddle location. It provides a `ConsumeAction` to allow
     * an actor to consume the water puddle.
     *
     * @param actor the Actor attempting to interact with the puddle
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of Actions, which contains a ConsumeAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Handles the consumption of the puddle by an actor. It heals the actor by 1 hit point and rewards them with stamina
     * points based on a percentage of their maximum stamina.
     *
     * @param actor the Actor consuming the puddle
     * @return a message describing the effect of consuming the puddle
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(1);
        int rewardStamina = (int)((actor.getAttributeMaximum(BaseActorAttributes.STAMINA) * .01f));
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, rewardStamina);
        return String.format("%s drinks from the water puddle. They feel refreshed.",actor) ;
    }

    /**
     * Returns a string representation of the puddle as "Water Puddle".
     *
     * @return a string representation of the puddle
     */
    @Override
    public String toString(){
        return "Water Puddle";
    }
}

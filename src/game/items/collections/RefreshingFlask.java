package game.items.collections;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeRefreshingFlaskAction;

/**
 * A class representing a refreshing flask item in the game.
 *
 * The refreshing flask can be consumed by actors to restore their stamina.
 *
 * @author Ong Chong How
 *
 * @see Consumable
 * @see ConsumeRefreshingFlaskAction
 *
 * @version 1.0
 */
public class RefreshingFlask extends Item implements Consumable {

    /**
     * Constructor to create a RefreshingFlask object.
     *
     * @param name        The name of this item.
     * @param displayChar The character to use to represent this item if it is on the ground.
     * @param portable    True if and only if the item can be picked up.
     */
    public RefreshingFlask(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * Generates a list of allowable actions when an actor interacts with this item.
     *
     * @param owner The actor interacting with the item.
     * @return An ActionList containing the action to consume the refreshing flask.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeRefreshingFlaskAction(this));
        return actionList;
    }

    /**
     * Returns a string representation of the refreshing flask.
     *
     * @return The string representation of the refreshing flask.
     */
    public String toString(){
        return "Refreshing Flask";
    }

    /**
     * Consumes the refreshing flask, restoring a portion of the actor's stamina,
     * and removes it from the actor's inventory.
     *
     * @param actor The actor consuming the flask.
     * @return The amount of stamina restored to the actor.
     */
    @Override
    public int consume(Actor actor) {
        int points = (int)(actor.getAttributeMaximum(BaseActorAttributes.STAMINA)*0.2f);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, points);
        actor.removeItemFromInventory(this);
        return points;
    }
}

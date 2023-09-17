package game.items.collections;

import edu.monash.fit2099.engine.items.Item;
import game.actions.Ability;

/**
 * A class representing an old key item in the game.
 * Old keys are used to unlock locked gates.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class OldKey extends Item {

    /**
     * Constructor to create an OldKey object.
     *
     * @param name        The name of this item.
     * @param displayChar The character to use to represent this item if it is on the ground.
     * @param portable    True if and only if the item can be picked up.
     */
    public OldKey(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.addCapability(Ability.UNLOCK_LOCKED_GATE);
    }
}

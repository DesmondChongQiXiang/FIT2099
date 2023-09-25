package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.capabilities.Ability;

/**
 * A class that represents Key that can unlock
 */
public class Key extends Item {
    /**
     * Constructor.
     */
    public Key() {
        super("Old Key", '-', true);
        this.addCapability(Ability.UNLOCK_GATE);
    }


}

package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.capabilities.Ability;

/**
 * A class that represents a Key that can unlock gates.
 *
 * @author MA_AppliedSession1_Group7
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

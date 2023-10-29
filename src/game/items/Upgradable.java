package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface for items that can be upgraded in the game.
 */
public interface Upgradable {

    /**
     * Upgrades the item using the specified actor as the upgrader.
     *
     * @param upgrader The actor performing the upgrade.
     * @return A description of the upgrade action and its effects.
     */
    String upgrade(Actor upgrader);
}

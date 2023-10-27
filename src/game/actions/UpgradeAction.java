package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Upgradable;

/**
 * A class representing an action where an actor upgrades an upgradable item.
 * Allows an actor to upgrade an upgradable item.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class UpgradeAction extends Action {

    /**
     * The item that the actor seeks to upgrade.
     */
    private final Upgradable upgradeItem;

    /**
     * Constructor for the UpgradeAction class that initializes the upgradable item to be upgraded.
     *
     * @param upgradeItem The upgradable item to be upgraded.
     */
    public UpgradeAction(Upgradable upgradeItem) {
        this.upgradeItem = upgradeItem;
    }

    /**
     * Executes the upgrade action, triggering the upgrade method of the upgradable item by the actor and returning the upgraded message.
     *
     * @param actor The actor performing the action.
     * @param map The game map.
     * @return The message indicating the result of the upgrade operation.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String upgradedMessage = upgradeItem.upgrade(actor);
        return upgradedMessage;
    }

    /**
     * Provides a description of the action that appears in the menu when the actor performs the upgrade action.
     *
     * @param actor The actor performing the action.
     * @return A string description representing the actor's action of upgrading the specified upgradable item.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s upgrades %s", actor, upgradeItem);
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Upgradable;

/**
 * A custom action class for upgrading an Upgradable item using an actor's abilities or resources.
 * This action allows the actor to upgrade a specific Upgradable item, which may result in an improvement or modification.
 */
public class UpgradeAction extends Action {

    private final Upgradable upgradeItem;

    /**
     * Constructor for the UpgradeAction.
     *
     * @param upgradeItem The Upgradable item to be upgraded.
     */
    public UpgradeAction(Upgradable upgradeItem) {
        this.upgradeItem = upgradeItem;
    }

    /**
     * Execute the action, allowing the actor to upgrade the specified Upgradable item.
     *
     * @param actor The actor who is performing the upgrade action.
     * @param map The GameMap on which the action is performed.
     * @return A String message describing the outcome of the upgrade.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String upgradedMessage = upgradeItem.upgrade(actor);
        return upgradedMessage;
    }

    /**
     * Get a description for the action that appears in the game's menu when the actor can choose to perform this action.
     *
     * @param actor The actor who is considering this action.
     * @return A String describing the action, typically including the actor and the Upgradable item to be upgraded.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s upgrades %s", actor, upgradeItem);
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Upgradable;

public class UpgradeAction extends Action {

    private final Upgradable upgradeItem;
    public UpgradeAction(Upgradable upgradeItem) {
        this.upgradeItem = upgradeItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String upgradedMessage = upgradeItem.upgrade(actor);
        return upgradedMessage;
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s upgrades %s", actor, upgradeItem);
    }
}

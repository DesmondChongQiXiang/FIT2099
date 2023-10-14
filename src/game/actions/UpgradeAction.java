package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Upgradable;

public class UpgradeAction extends Action {

    private final Upgradable upgradeItem;
    private final int upgradePrice;

    public UpgradeAction(Upgradable upgradeItem, int upgradePrice) {
        this.upgradeItem = upgradeItem;
        this.upgradePrice = upgradePrice;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        try{
            int finalUpgradePrice = upgradeItem.upgrade(actor, upgradePrice);
            return String.format("%s successfully upgraded %s for %d runes.",actor, upgradeItem, finalUpgradePrice);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s can upgrade %s", actor, upgradeItem);
    }
}

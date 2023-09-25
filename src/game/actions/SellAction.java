package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;
import game.items.Sellable;

public class SellAction extends Action {

    private Sellable item;

    public SellAction(Sellable item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
       int sellingPrice = item.soldBy(actor);
       return String.format("%s sells %s for %d runes",actor,item,sellingPrice);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s sells %s", actor,item);
    }
}

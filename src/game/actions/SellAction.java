package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;
import game.items.Sellable;

public class SellAction extends Action {

    private Actor purchaser;
    private Sellable item;

    public SellAction(Actor purchaser, Sellable item) {
        this.purchaser = purchaser;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

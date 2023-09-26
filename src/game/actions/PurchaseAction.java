package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;

public class PurchaseAction extends Action {
    private final Purchasable item;

    public PurchaseAction(Actor buyer, Purchasable item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        try{
            int purchasePrice = item.purchasedBy(actor);
            return String.format("%s successfully purchased %s for %d runes.",actor, item, purchasePrice);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s buys %s", actor,item);
    }
}


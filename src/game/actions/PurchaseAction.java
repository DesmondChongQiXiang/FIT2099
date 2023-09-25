package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;

public class PurchaseAction extends Action {
    private final Actor seller;
    private final Purchasable item;

    private boolean isPurchased;

    public PurchaseAction(Actor seller, Purchasable item){
        this.seller = seller;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        item.purchasedBy(actor);
        return "halo";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}

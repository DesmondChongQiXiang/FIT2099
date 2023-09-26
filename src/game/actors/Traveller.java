package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actions.PurchaseAction;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Purchasable;
import game.items.RefreshingFlask;
import game.weapons.Broadsword;

public class Traveller extends Actor {

    /**
     * The constructor of the Actor class.
     */
    public Traveller() {
        super("Traveller", 'ඞ', 0);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Ability.BUYING)){
            actions.add(new PurchaseAction(otherActor,new HealingVial()));
            actions.add(new PurchaseAction(otherActor,new RefreshingFlask()));
            actions.add(new PurchaseAction(otherActor,new Broadsword()));
        }
        return actions;
    }
}

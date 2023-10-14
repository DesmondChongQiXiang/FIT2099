package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ListenMonologueAction;
import game.capabilities.Ability;

public class Blacksmith extends Actor {

    public Blacksmith() {
        super("Blacksmith", 'B', 0);
        this.addCapability(Ability.UPGRADE_EQUIREMENT);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.LISTEN_STORY)){
            actions.add(new ListenMonologueAction());
        }
        return actions;
    }
}

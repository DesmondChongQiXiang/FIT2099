package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.MonologueOptions;

import java.util.ArrayList;
import java.util.Random;

public class ListenMonologueAction extends Action {
    private Random rand = new Random();
    private MonologueOptions monologueOptions;

    public ListenMonologueAction(MonologueOptions monologueOptions){
        this.monologueOptions = monologueOptions;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return monologueOptions.chooseOption();
    }

    @Override
    public String menuDescription(Actor actor) {
        return "listen to " + actor;
    }
}

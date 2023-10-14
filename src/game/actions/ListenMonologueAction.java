package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

public class ListenMonologueAction extends Action {
    private Random rand = new Random();
    private ArrayList<String> monologueList;

    public ListenMonologueAction(ArrayList<String> monologueList){
        this.monologueList = monologueList;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return monologueList.get(rand.nextInt(monologueList.size()));
    }

    @Override
    public String menuDescription(Actor actor) {
        return "listen to " + actor;
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.MonologueOptions;
import java.util.Random;

public class ListenMonologueAction extends Action {
    private Random rand = new Random();
    private MonologueOptions monologueOptions;
    private Actor speaker;
    public ListenMonologueAction(MonologueOptions monologueOptions, Actor speaker){
        this.monologueOptions = monologueOptions;
        this.speaker = speaker;
    }

    /**
     * Executes the listening action.
     *
     * @param actor The actor performing the action.
     * @param map The game map.
     * @return The chosen monologue option.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String chosenMonologue = monologueOptions.chooseOption();
        return chosenMonologue;
    }

    /**
     * Describes the action in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string description.
     */
    @Override
    public String menuDescription(Actor actor) {

        return actor + " listen to " + speaker;
    }
}

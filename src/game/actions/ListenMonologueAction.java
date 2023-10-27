package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.monologues.Talkable;

public class ListenMonologueAction extends Action {
    private Talkable speaker;
    public ListenMonologueAction(Talkable speaker){
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
        String chosenMonologue = speaker.chooseOption();
        return String.format("%s: %s",speaker,chosenMonologue);
    }

    /**
     * Describes the action in the menu.
     *
     * @param actor The actor performing the action.
     * @return A string description.
     */
    @Override
    public String menuDescription(Actor actor) {

        return actor + " listens to " + speaker;
    }
}

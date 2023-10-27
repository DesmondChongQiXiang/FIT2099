package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.monologues.Talkable;

/**
 * A class that represents the action of an actor listening to a monologue from a Talkable speaker.
 * Allows an actor to listen to a monologue provided by the Talkable speaker.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class ListenMonologueAction extends Action {

    /**
     * The speaker providing the monologue options
     */
    private Talkable speaker;

    /**
     * Constructor for the ListenMonologueAction class that initializes the Talkable speaker.
     *
     * @param speaker The Talkable speaker providing the monologue options.
     */
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
     * Provides a description of the action that appears in the menu when the actor performs the listening action.
     *
     * @param actor The actor performing the action.
     * @return A string description representing the action of the actor listening to the speaker.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + speaker;
    }
}

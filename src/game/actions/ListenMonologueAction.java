package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.monologues.Talkable;

/**
 * A custom action class for an actor to listen to a monologue from a "Talkable" character.
 * This action allows the actor to interact with a character who can provide monologues and listen to a chosen monologue.
 */
public class ListenMonologueAction extends Action {
    private Talkable speaker;

    /**
     * Constructor for the ListenMonologueAction.
     *
     * @param speaker The "Talkable" character from whom the actor is going to listen to a monologue.
     */
    public ListenMonologueAction(Talkable speaker){
        this.speaker = speaker;
    }

    /**
     * Execute the action, allowing the actor to listen to a monologue from the speaker.
     *
     * @param actor The actor who is listening to the monologue.
     * @param map The GameMap on which the action is performed.
     * @return A String representing the interaction between the actor and the speaker, including the chosen monologue.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String chosenMonologue = speaker.chooseOption();
        return String.format("%s: %s",speaker,chosenMonologue);
    }

    /**
     * Get a description for the action that appears in the game's menu when the actor can choose to perform this action.
     *
     * @param actor The actor who is considering this action.
     * @return A String describing the action, typically including the actor and the speaker.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + speaker;
    }
}

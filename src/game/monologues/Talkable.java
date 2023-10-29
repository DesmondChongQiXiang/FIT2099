package game.monologues;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.ArrayList;

/**
 * An interface for actors that can engage in conversations and provide monologue options.
 */
public interface Talkable {

    /**
     * An ArrayList of monologue options that the actor can provide during a conversation.
     */
    final ArrayList<String> monologueOptions = new ArrayList<>();

    /**
     * Adds monologue options to the actor based on the listener's actions or state.
     *
     * @param listener The actor who is listening to the conversation.
     */
    void addMonologueOptions(Actor listener);

    /**
     * Allows the actor to choose an option from their available monologue options during a conversation.
     *
     * @return The selected monologue option.
     */
    String chooseOption();
}

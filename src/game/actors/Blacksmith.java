package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ListenMonologueAction;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.monologues.Talkable;

import java.util.Random;

/**
 * A class representing a Blacksmith actor in the game.
 * The Blacksmith is an important character who can offer monologues and upgrade equipment for adventurers.
 */
public class Blacksmith extends Actor implements Talkable {

    /**
     * Constructor for creating a Blacksmith actor.
     */
    public Blacksmith() {
        super("Blacksmith", 'B', 0);
        this.addCapability(Ability.UPGRADE_EQUIPMENT);
    }

    /**
     * Overrides the playTurn method to make the Blacksmith take no action during its turn.
     *
     * @param actions The list of available actions for the Blacksmith.
     * @param lastAction The last action the Blacksmith performed.
     * @param map The GameMap where the Blacksmith is located.
     * @param display The display used to render the game world.
     * @return A DoNothingAction to indicate that the Blacksmith takes no action during its turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Determines the allowable actions for the Blacksmith when interacting with another actor.
     *
     * @param otherActor The other actor with which the Blacksmith interacts.
     * @param direction The direction of interaction.
     * @param map The GameMap where the interaction occurs.
     * @return An ActionList containing allowable actions based on the capabilities of the other actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.LISTEN_STORY)) {
            this.addMonologueOptions(otherActor);
            actions.add(new ListenMonologueAction(this));
        }
        return actions;
    }

    /**
     * Adds monologue options for the Blacksmith actor based on the capabilities of the listening actor.
     * This method clears the existing monologue options and adds new ones according to the capabilities of
     * the actor who is interacting with the Blacksmith.
     *
     * @param listener The actor who will hear the monologue. The monologue options depend on the capabilities of this Actor.
     */
    @Override
    public void addMonologueOptions(Actor listener){
        this.monologueOptions.clear();
        monologueOptions.add("I used to be an adventurer like you, but then …. Nevermind, let’s get back to smithing.");
        monologueOptions.add("It’s dangerous to go alone. Take my creation with you on your adventure!");
        monologueOptions.add("Ah, it’s you. Let’s get back to make your weapons stronger.");
        if (listener.hasCapability(Ability.USE_GREATKNIFE)) {
            monologueOptions.add("Hey now, that’s a weapon from a foreign land that I have not seen for so long. I can upgrade it for you if you wish.");
        }
        if (listener.hasCapability(Status.BOSS_DEFEATED)) {
            monologueOptions.add("Somebody once told me that a sacred tree rules the land beyond the ancient woods until this day.");
        } else {
            monologueOptions.add("Beyond the burial ground, you’ll come across the ancient woods ruled by Abxervyer. Use my creation to slay them and proceed further!");
        }
    }

    /**
     * Choose a monologue option randomly from the available options.
     *
     * @return A randomly selected monologue option enclosed in double quotes.
     */
    @Override
    public String chooseOption() {
        Random rand = new Random();
        String chosenMessage = monologueOptions.get(rand.nextInt(monologueOptions.size()));
        return String.format("\"%s\"",chosenMessage);
    }
}
package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ListenMonologueAction;
import game.actions.PurchaseAction;
import game.capabilities.Ability;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.monologues.Talkable;
import game.weapons.Broadsword;
import game.weapons.GreatKnife;
import game.capabilities.Status;

import java.util.Random;


/**
 * The Traveller class represents a specialized actor in the game world.
 * It extends the Actor class and provides additional functionality for interacting with other actors,
 * such as buying and selling items.
 *
 * The Traveller is a non-player character (NPC) capable of selling various items to other actors
 * with the "BUYING" capability. It offers items such as Healing Vials, Refreshing Flasks, Broadswords, and Great Knives
 * in exchange for the corresponding currency.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Actor
 */
public class Traveller extends Actor implements Talkable{

    /**
     * Constructor to initialize the Traveller actor.
     */
    public Traveller() {
        super("Traveller", 'ඞ', 0);
        this.addCapability(Ability.BUYING);
    }

    /**
     * Defines the behavior of the Traveller during its turn.
     *
     * @param actions    The list of actions the Traveller can perform.
     * @param lastAction The last action performed.
     * @param map        The game map.
     * @param display    The display interface.
     * @return The action to be performed.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Returns the allowable actions that can be performed with this actor.
     *
     * @param otherActor The actor interacting with the Traveller.
     * @param direction  The direction of the interaction.
     * @param map        The game map.
     * @return A list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Ability.BUYING)) {
            int healingVialPrice = 100;
            actions.add(new PurchaseAction(new HealingVial(), healingVialPrice));

            int refreshingFlaskPrice = 75;
            actions.add(new PurchaseAction(new RefreshingFlask(), refreshingFlaskPrice));

            int broadswordPrice = 250;
            actions.add(new PurchaseAction(new Broadsword(), broadswordPrice));

            int greatKnifePrice = 300;
            actions.add(new PurchaseAction(new GreatKnife(), greatKnifePrice));
        }

        if (otherActor.hasCapability(Ability.LISTEN_STORY)) {
            this.addMonologueOptions(otherActor);
            actions.add(new ListenMonologueAction(this));
        }

        return actions;
    }

    /**
     * Adds monologue options for the Traveller actor based on the capabilities of the listening actor.
     * This method clears the existing monologue options and adds new ones according to the capabilities of
     * the actor who is interacting with the Traveller.
     *
     * @param listener The actor who will hear the monologue. The monologue options depend on the capabilities of this Actor
     */
    @Override
    public void addMonologueOptions(Actor listener) {
        this.monologueOptions.clear();
        monologueOptions.add("Of course, I will never give you up, valuable customer!");
        monologueOptions.add("I promise I will never let you down with the quality of the items that I sell.");
        monologueOptions.add("You can always find me here. I'm never gonna run around and desert you, dear customer!");
        monologueOptions.add("I'm never gonna make you cry with unfair prices.");
        monologueOptions.add("Trust is essential in this business. I promise I’m never gonna say goodbye to a valuable customer like you.");
        monologueOptions.add("Don't worry, I’m never gonna tell a lie and hurt you.");

        if (listener.hasCapability(Ability.USE_GIANTHAMMER)) {
            monologueOptions.add("Ooh, that’s a fascinating weapon you got there. I will pay a good price for it. You wouldn't get this price from any other guy.");
        }
        if (!listener.hasCapability(Status.BOSS_DEFEATED)){
            monologueOptions.add("You know the rules of this world, and so do I. Each area is ruled by a lord. Defeat the lord of this area, Abxervyer, and you may proceed to the next area.");
        }
        else if (listener.hasCapability(Ability.USE_GIANTHAMMER)) {
            monologueOptions.add("Congratulations on defeating the lord of this area. I noticed you still hold on to that hammer. Why don’t you sell it to me? We've known each other for so long. I can tell you probably don’t need that weapon any longer.");
        }
    }

    /**
     * Chooses a monologue option to be spoken by the Traveller.
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


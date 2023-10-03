package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.capabilities.Ability;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.weapons.Broadsword;
import game.weapons.GreatKnife;

/**
 * The Traveller class represents a specialized actor in the game world.
 * It extends the Actor class and provides additional functionality for interacting with other actors, such as buying and selling items.
 *
 * Modified By:
 */
public class Traveller extends Actor {

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
     * @param actions The list of actions the Traveller can perform.
     * @param lastAction The last action performed.
     * @param map The game map.
     * @param display The display interface.
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
     * @param direction The direction of the interaction.
     * @param map The game map.
     * @return A list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Ability.BUYING)){
            int healingVialPrice = 100;
            actions.add(new PurchaseAction(new HealingVial(), healingVialPrice));

            int refreshingFlaskPrice = 75;
            actions.add(new PurchaseAction(new RefreshingFlask(),refreshingFlaskPrice));

            int broadswordPrice = 250;
            actions.add(new PurchaseAction(new Broadsword(),broadswordPrice));

            int greatKnifePrice = 300;
            actions.add(new PurchaseAction(new GreatKnife(),greatKnifePrice));
        }
        return actions;
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Ability;
import game.grounds.Gate;

/**
 * An Action that allows an actor to unlock a gate.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class UnlockGateAction extends Action {

    /**
     * The target gate to unlock.
     */
    private final Gate gate;

    /**
     * Constructor to create an Action that will unlock a gate.
     *
     * @param gate The target gate to unlock.
     */
    public UnlockGateAction(Gate gate){
        this.gate = gate;
    }

    /**
     * Allow the Actor to unlock a gate
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Ability.UNLOCK_GATE)){
            gate.unlockGate();
            return "Gate is now unlocked.";
        }
        return "Gate is locked shut.";
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player unlock Gate"
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s unlocks Gate",actor);
    }


}

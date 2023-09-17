package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.gates.Gate;

/**
 * A custom Action class that represents an actor unlocking a gate.
 * This action allows an actor to unlock a specific gate if they have the required capability.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class UnlockGateAction extends Action {

    /**
     * The gate to be unlocked.
     */
    private Gate lockedGate;

    /**
     * Constructor for the UnlockGateAction class.
     *
     * @param lockedGate The gate to be unlocked.
     */
    public UnlockGateAction(Gate lockedGate) {
        this.lockedGate = lockedGate;
    }

    /**
     * Executes the unlocking action by checking the actor's capability and unlocking the gate if possible.
     *
     * @param actor The actor attempting to unlock the gate.
     * @param map   The GameMap on which the action is performed.
     * @return A string describing the outcome of the unlocking action (e.g., "Gate is now unlocked." or "Gate is locked shut.").
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String res = "";
        if(actor.hasCapability(Ability.UNLOCK_LOCKED_GATE)){
            lockedGate.setUnlocked(true);
            res = "Gate is now unlocked.";
        }else{
            res = "Gate is locked shut.";
        }
        return res;
    }

    /**
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "Bob unlocks Gate").
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s unlocks Gate",actor);
    }
}

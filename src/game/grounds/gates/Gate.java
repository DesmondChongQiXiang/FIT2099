package game.grounds.gates;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.UnlockGateAction;

/**
 * An abstract class representing a gate in the game world.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public abstract class Gate extends Ground {

    private boolean isUnlocked;
    private Action action;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Gate(char displayChar) {
        super(displayChar);
        this.isUnlocked = false;
    }

    /**
     * Checks if an actor can enter this gate.
     *
     * @param actor The actor trying to enter.
     * @return True if the gate is unlocked, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return isUnlocked;
    }

    /**
     * Generates a list of allowable actions for an actor at this gate location.
     *
     * @param actor     The actor at the gate.
     * @param location  The location of the gate.
     * @param direction The direction to the gate.
     * @return A list of allowable actions, including unlocking the gate if it's locked.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        if(!isUnlocked){
            actionList.add(new UnlockGateAction(this));
        }
        else{
            actionList.add(action);
        }
        return actionList;
    }

    /**
     * Sets the locked or unlocked state of the gate.
     *
     * @param unlocked True if the gate should be unlocked, false otherwise.
     */
    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    /**
     * Adds a sample action that can be performed when the gate is unlocked.
     *
     * @param newAction The action to be added.
     */
    public void addSampleAction(Action newAction){
        this.action = newAction;
    }
}

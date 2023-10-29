package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetNotifiable;
import game.reset.Resettable;
import game.actions.TravelAction;
import game.actions.UnlockGateAction;
import game.capabilities.Ability;
import java.util.ArrayList;

/**
 * The `Gate` class represents a gate or door that can be locked or unlocked in the game. It is a type of ground
 * environment represented by the character '=' on the game map.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class Gate extends Ground implements ResetNotifiable, Resettable {

    /**
     * Travel Action that is used to transfer an actor through the gate.
     */
    private ArrayList<TravelAction> travelActionList;

    /**
     * The status of the gate (locked or unlocked).
     */
    private boolean isUnlocked;
    private boolean resetRequired;

    /**
     * Constructor to create a `Gate` instance. Initially, the gate is locked and has the capability `LOCKED_GATE`.
     */
    public Gate(){
        super('=');
        isUnlocked = false;
        this.travelActionList = new ArrayList<>();
        resetRequired = false;
    }

    /**
     * Called at each game tick to determine if a reset is required.
     *
     * @param location The location of the gate.
     */
    @Override
    public void tick(Location location) {
        if(resetRequired){
            reset(location);
        }
        resetRequired = false;
    }

    /**
     * Notifies the gate that a reset is required.
     */
    @Override
    public void notifyReset() {
        resetRequired = true;
    }

    /**
     * Resets the gate, locking it and adding the `LOCKED_GATE` capability.
     *
     * @param location The location of the gate.
     */
    @Override
    public void reset(Location location) {
        isUnlocked = false;
        resetRequired = false;
    }

    /**
     * Checks whether the gate is unlocked and allows an actor to enter if it is unlocked.
     *
     * @param actor the Actor attempting to enter
     * @return true if the gate is unlocked and the actor can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return isUnlocked;
    }

    /**
     * Returns a list of allowable actions for an actor at this gate location. If the gate is locked, it provides an
     * `UnlockGateAction` to unlock the gate. If the gate is unlocked, it provides the `TravelAction` to transfer the
     * actor through the gate.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of Actions, which may contain an UnlockGateAction or a TravelAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!isUnlocked) {
            actions.add(new UnlockGateAction(this));
        }
        else{
            for(TravelAction travelAction : travelActionList){
                actions.add(travelAction);
            }
        }
        return actions;
    }

    /**
     * Unlocks the gate by setting the isUnlocked attribute to true and removing the LOCKED_GATE capability.
     */
    public void unlockGate(){
        isUnlocked = true;
    }

    /**
     * Adds a TravelAction to the gate's list of TravelActions.
     *
     * @param travelAction The TravelAction to be added.
     */
    public void addTravelAction(TravelAction travelAction){
        travelActionList.add(travelAction);
    }


}

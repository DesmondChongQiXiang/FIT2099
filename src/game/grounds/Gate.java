package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.actions.UnlockGateAction;
/**
 * A class that represents Gate.
 */

public class Gate extends Ground {
    /**
     * Travel Action that used to transfer the actor
     */
    private TravelAction travelAction;

    /**
     * The status of the gate (locked or unlocked)
     */
    private boolean isUnlocked;
    /**
     * Constructor.
     */
    public Gate(){
        super('=');
        isUnlocked = false;
    }

    /**
     * Returns a boolean whether the gate is unlocked
     *
     * @param actor the Actor that tried to enter
     * @return a boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return isUnlocked;
    }

    /**
     * If the gate is not unlocked returns an UnlockGateAction, otherwise return a TravelAction
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collections of Actions that contains either UnlockGateAction or TravelAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!isUnlocked) {
            actions.add(new UnlockGateAction(this));
        }
        else{
            actions.add(travelAction);
        }
        return actions;
    }

    /**
     * set the travelAction attribute
     * @param travelAction a TravelAction that can transfer an actor
     */
    public void addTravelAction(TravelAction travelAction){
        this.travelAction = travelAction;
    }

    /**
     * set the isUnlocked attribute to true
     */
    public void unlockGate(){
        isUnlocked = true;
    }
}

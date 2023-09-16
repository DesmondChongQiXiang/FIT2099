package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.UnlockGateAction;
import game.utils.Ability;

/**
 * A class that represents a gate.
 * It is used to create a gate that allows actor to travel to a different location.
 *
 * @author Yoong Qian Xin
 */
public class Gate extends Ground {

  private Location destination;  // location associated with the destination
  private String direction;
  private boolean isGateLocked;

  /**
   * Constructor.
   * @param destination the name of destination to be traveled
   * @param direction the location of gate to teleport
   */
  public Gate(Location destination, String direction) {
    super('=');
    this.destination = destination;  // Abandoned Village or Burial Ground
    this.direction = direction;
    this.isGateLocked = true;
  }

  /**
   * Set the gate status to false as indicating gate is locked.
   */
  public void unlockGate() {isGateLocked = false;}

  /**
   * Returns a list of allowable actions for the actor at the gate location.
   * If the actor has the Old Key in item inventory, indicating player has the ability to travel,
   * a MoveActorAction to the destination is added to the action list.
   *
   * @param actor     the actor for which to generate allowable actions
   * @param location  the location where actor lies on
   * @param direction the direction in which the actor is facing
   *
   * @return an ActionList containing the allowable actions
   */
  public ActionList allowableActions(Actor actor, Location location, String direction) {  // What actions that the Player is allowed to use on Locked Gate?
    ActionList actions = new ActionList();

    if (isGateLocked) {
      actions.add(new UnlockGateAction(this, direction));  // The Player can perform UnlockGateAction
    } else {
        if (actor.hasCapability(Ability.TRAVEL)) {
          actions.add(new MoveActorAction(destination, this.direction));
        }
    }
      return actions;
    }


}




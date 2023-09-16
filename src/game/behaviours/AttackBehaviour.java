package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;

/**
 * A class that represents the behaviour of a spawned enemy to attack other actors.
 *
 * @author Yoong Qian Xin
 */
public class AttackBehaviour implements Behaviour {
  private Actor targetActor;
  private String direction;

  /**
   * Constructor.
   *
   * @param target the target actor to be attacked
   * @param direction the direction where the attack should be performed (only used for display purposes)
   */
  public AttackBehaviour(Actor target, String direction) {
    this.targetActor = target;
    this.direction = direction;
  }

  /**
   * Returns a AttackAction to attack the target actor when target actor is nearby or one block away
   * If no movement is possible, returns null.
   *
   * @param actor the Actor acting the behaviour
   * @param map   the map that actor is currently on
   *
   * @return an Action that actor can perform, or null if actor can't do this.
   */
  @Override
  public Action getAction(Actor actor, GameMap map) {

    // checks if the current game map contains actor with this behavior or the target actor
    if (!map.contains(targetActor) || !map.contains(actor)) {
      return null;
    }

    return new AttackAction(targetActor, direction);
  }


}

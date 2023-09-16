package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.Gate;
import game.utils.Ability;

import java.util.List;

/**
 * A class that represents the unlock action for an actor which can be done on gate.
 *
 * @author Yoong Qian Xin
 */
public class UnlockGateAction extends Action {
  private Gate gate;
  private String direction;

  /**
   * Constructor.
   *
   * @param gate the instance of gate
   * @param direction the name of the gameMap to travel to
   */
  public UnlockGateAction(Gate gate, String direction){
    this.gate = gate;
    this.direction = direction;  // Abandoned Village or Burial Ground
  }

  /**
   * Execution of the UnlockGate action.
   *
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   *
   * @return The result string to be printed on the console.
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    List<Item> actorInventory = actor.getItemInventory();
    for (Item item : actorInventory) {
      if (item.hasCapability(Ability.OPEN_GATE)) {
        gate.unlockGate();  // set the gate status to false as indicating gate is unlocked
        return "Gate is now unlocked";
      }
    }
    return "Gate is locked shut";
  }

  /**
   * The action description to be printed on the menu to let the user choose.
   *
   * @param actor The actor performing the action.
   *
   * @return The string to be printed on the menu.
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " unlocks Gate";
  }


}
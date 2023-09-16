package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Broadsword;

/**
 * A class that represents the Focus action for the Broadsword.
 *
 * @author Yoong Qian Xin
 */
public class FocusAction extends Action {
  private Broadsword broadsword;

  /**
   * Constructor.
   *
   * @param broadsword the instance of the Broadsword class
   */
  public FocusAction(Broadsword broadsword) {
    this.broadsword = broadsword;
  }

  /**
   * Execution of the Focus action.
   *
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   *
   * @return The result string to be printed on the console.
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    String ret = "";

    broadsword.setFocusActive(true);
    broadsword.increaseDamageMultiplier(0.10f);

    if (broadsword.getFocusTurns() == 0) {
      broadsword.updateHitRate(90);
    }
    int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.STAMINA);
    int staminaCost = maxStamina / 5;  // the stamina cost to activate the focus skill is 20% of player's maximum stamina
    if (actor.getAttribute(BaseActorAttributes.STAMINA) >= staminaCost) {
      actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
      ret += actor + " takes a deep breath and focuses all their might!";
    } else {
        ret += "Insufficient stamina!";
    }

    return ret;
  }

  /**
   * The action description to be printed on the menu to let the user choose.
   *
   * @param actor The actor performing the action.
   * @return The string to be printed on the menu.
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " activates the skill of " + this.broadsword;
  }


}
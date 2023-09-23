package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * A class that represents an item which will be dropped when the enemy is defeated.
 *
 * @author Yoong Qian Xin
 */
public class HealingVial extends Item implements Consumable{
  private boolean isActorConsumed;

  /**
   * Constructor.
   */
  public HealingVial(){
    super("HealingVial", 'a', true);
    this.isActorConsumed = false;
  }

  /**
   * Each time the player uses it, their health will increase by 10% of their maximum health points.
   * It can only be consumed once by the player and cannot be consumed directly from the ground.
   * They must be picked up by the player before being consumed.
   *
   * @param actor the actor who owns the HealingVial item
   *
   * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
   */
  public String consumedBy(Actor actor) {
    int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.HEALTH);
    int healingPoints = maxStamina / 10;
    actor.heal(healingPoints);
    isActorConsumed = true;

    if (isActorConsumed){
      actor.removeItemFromInventory(this);
    }

    return actor + " consumes Healing Vial and Healing Vial heals " + actor + " by " + healingPoints + " points.";
  }

  /**
   * List of allowable actions that the Healing Vial can perform to the current actor.
   * The Player can perform ConsumeAction on HealingVial.
   *
   * @param owner the actor that owns the item
   *
   * @return a list of Actions for actor acts on the HealingVials item
   */
  public ActionList allowableActions(Actor owner){
    ActionList actions = new ActionList();
    actions.add(new ConsumeAction(this));
    return actions;
  }


}

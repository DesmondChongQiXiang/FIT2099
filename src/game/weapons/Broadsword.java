package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.FocusAction;
import game.utils.Ability;

/**
 * A class that represents a specific type of weapon item called Broadsword.
 *
 * @author Yoong Qian Xin
 */
public class Broadsword extends WeaponItem {
  private final float DEFAULT_DAMAGE_MULTIPLIER = 1.0f;  // store the original damage multiplier before using Focus
  private boolean isFocusActive;  // track if the Focus skill is active
  private int focusTurns = 5;
  private int originalHitRate = 80;

  /**
   * Constructor.
   */
  public Broadsword(String name, char displayChar, int damage, String verb, int hitRate) {
    super(name, displayChar, damage, verb, hitRate);
    this.isFocusActive = false;
    this.addCapability(Ability.WEAPON_SPECIAL_SKILL);
  }

  /**
   * Performs the tick action for the Broadsword weapon item, called once per turn,
   * so that maps can experience the passage of time.
   *
   * @param currentLocation The location of the actor carrying this Broadsword.
   * @param actor The actor carrying this Broadsword.
   */
  @Override
  public void tick(Location currentLocation, Actor actor) {
    if (isFocusActive) {
      focusTurns -= 1;
      int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.STAMINA);
      actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, maxStamina / 100);  // recover 1% of max stamina

      if (focusTurns == 0) {
        deactivateFocusSkill();
      }
    }
  }

  /**
   * Inform Broadsword weapon item on the ground of the passage of time.
   * Called once per turn, if the item rests upon the ground.
   *
   * @param currentLocation The location of the ground on which we lie.
   */
  public void tick(Location currentLocation) {
    deactivateFocusSkill();
  }

  /**
   * If the player drops the weapon while the skill is active,
   * the weapon’s damage multiplier and hit rate will revert back to the previous state.
   */
  public void deactivateFocusSkill() {  // skill has expired, revert to original state
    isFocusActive = false;
    updateDamageMultiplier(DEFAULT_DAMAGE_MULTIPLIER);
    updateHitRate(originalHitRate);
  }

  /**
   * Returns the Broadsword's focus skill turns.
   *
   * @return the number of focus skill turns
   */
  public int getFocusTurns(){
    return focusTurns;
  }

  /**
   * Set the focus skill turn.
   * .
   * @param focusActive Boolean to indicate whether if the focus is active
   */
  public void setFocusActive(boolean focusActive){
    isFocusActive = focusActive;
  }

  /**
   * List of allowable actions that the Broadsword item can perform to the current actor.
   * The Player can perform FocusAction on Broadsword.
   *
   * @param owner the actor that owns the item
   *
   * @return a list of Actions for actor acts on Broadsword
   */
  @Override
  public ActionList allowableActions(Actor owner) {
    ActionList actions = new ActionList();
    actions.add(new FocusAction(this));
    return actions;
  }

  /**
   * List of allowable actions that the Broadsword item allows its owner do to other actor.
   * Return an attacking action to the other actor.
   *
   * @param otherActor the other actor
   * @param location the location of the other actor
   *
   * @return a list of Actions for actor to perform to other actor
   */
  @Override
  public ActionList allowableActions(Actor otherActor, Location location) {
    ActionList actions = new ActionList();
    actions.add(new AttackAction(otherActor, location.map().getActorAt(location).toString(), this));
    return actions;
  }


}
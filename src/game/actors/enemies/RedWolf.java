package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Runes;

/**
 * Class representing the Red Wolf, a type of Enemy actor in the game.
 */
public class RedWolf extends Enemy{

  /**
   * Constructor to create a Red Wolf enemy.
   */
  public RedWolf(){

    super("Red Wolf", 'r', 25);
  }

  /**
   * Creates an individual intrinsic weapon for the Red Wolf.
   * Overrides Actor.getIntrinsicWeapon().
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new Intrinsic Weapon for the Red Wolf.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(15, "bites", 80);
  }

  /**
   * Method that can be executed when the Red Wolf is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator who caused the Red Wolf to become unconscious.
   * @param map   The GameMap where the Red Wolf fell unconscious.
   * @return A string describing what happened when the Red Wolf is unconscious.
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.10){
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(25));
    return super.unconscious(actor, map);
  }

  /**
   * Defines the allowable actions for the Red Wolf based on the presence of hostile actors.
   *
   * @param otherActor The Actor that might be performing an attack.
   * @param direction  String representing the direction of the other Actor.
   * @param map        The current GameMap.
   * @return A list of actions that is allowed to be executed/performed on the current actor.
   */
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
    ActionList actions = new ActionList();
    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
      this.behaviours.put(998, new FollowBehaviour(otherActor));
      actions.add(new AttackAction(this, direction));
    }

    return actions;
  }


}

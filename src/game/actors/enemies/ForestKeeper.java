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
 * Class representing the Forest Keeper, an enemy actor in the game.
 */
public class ForestKeeper extends Enemy {

  /**
   * Constructor to create a Forest Keeper.
   */
  public ForestKeeper(){
    super("Forest Keeper", '8', 125);
  }

  /**
   * Create an individual intrinsic weapon for the Forest Keeper.
   *
   * Overrides Actor.getIntrinsicWeapon().
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new Intrinsic Weapon for the Forest Keeper.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(25, "punches", 75);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
   *
   * @param actor the perpetrator
   * @param map where the Forest Keeper fell unconscious
   * @return a string describing what happened when the Forest Keeper is unconscious
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.20){
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(50));
    return super.unconscious(actor, map);
  }

  /**
   * Enemy can follow an actor that has the HOSTILE_TO_ENEMY capability.
   *
   * @param otherActor The Actor that might be performing an attack.
   * @param direction  String representing the direction of the other Actor.
   * @param map        Current GameMap.
   * @return A list of actions that are allowed to be executed/performed on the current actor.
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

package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;

public class RedWolf extends Enemy{

  /**
   * Constructor.
   */
  public RedWolf(){
    super("Red Wolf", 'r', 25);
  }

  /**
   * create a individual intrinsic weapon for Red Wolf
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return a new Intrinsic Weapon
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(15, "bites", 80);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to natural causes or accident.
   *
   * @param map where the Forest Keeper fell unconscious
   *
   * @return a string describing what happened when the Forest Keeper is unconscious
   */
  public String unconscious(GameMap map) {
    return super.unconscious(map);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
   *
   * @param actor the perpetrator
   * @param map where the Forest Keeper fell unconscious
   * @return a string describing what happened when the Forest Keeper is unconscious
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.10){
      map.locationOf(this).addItem(new HealingVial());
    }

    return super.unconscious(actor, map);
  }

  /**
   * Enemy can follow actor that has the HOSTILE_TO_ENEMY capability.
   *
   * @param otherActor the Actor that might be performing attack
   * @param direction  String representing the direction of the other Actor
   * @param map        current GameMap
   * @return A list of actions that is allowed to be executed/performed on the current actor.
   */
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
    ActionList actions = new ActionList();
    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
      this.behaviours.put(997, new FollowBehaviour(otherActor));
      actions.add(new AttackAction(this, direction));
    }

    return actions;
  }


}

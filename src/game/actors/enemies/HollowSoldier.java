package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.HealingVial;
import game.items.RefreshingFlask;

/**
 * Class representing the HollowSoldier.
 */
public class HollowSoldier extends Enemy {

  /**
   * Constructor.
   */
  public HollowSoldier(){
    super("Hollow Soldier", '&', 200);
  }

  /**
   * create a individual intrinsic weapon for Hollow Soldier
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return a new Intrinsic Weapon
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(50, "whacks", 50);
  }

  /**
   * Method that can be executed when the actor is unconscious due to the action of another actor
   * @param actor the perpetrator
   * @param map where the actor fell unconscious
   * @return a string describing what happened when the actor is unconscious
   */
  @Override
  public String unconscious(Actor actor,GameMap map) {
    if(Math.random() <=  0.30){
      map.locationOf(this).addItem(new RefreshingFlask());
    }

    if (Math.random() <= 0.20){
      map.locationOf(this).addItem(new HealingVial());
    }

    return super.unconscious(map);
  }


}

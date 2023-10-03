package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.items.Runes;
import game.capabilities.Status;

/**
 * Class representing the Hollow Soldier, a type of Enemy actor in the game.
 */
public class HollowSoldier extends Enemy {

  /**
   * Constructor to create a Hollow Soldier enemy.
   */
  public HollowSoldier(){

    super("Hollow Soldier", '&', 200);
  }

  /**
   * Creates an individual intrinsic weapon for the Hollow Soldier.
   * Overrides Actor.getIntrinsicWeapon().
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new Intrinsic Weapon for the Hollow Soldier.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(50, "whacks", 50);
  }

  /**
   * Method that can be executed when the Hollow Soldier is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator who caused the Hollow Soldier to become unconscious.
   * @param map   The GameMap where the Hollow Soldier fell unconscious.
   * @return A string describing what happened when the Hollow Soldier is unconscious.
   */
  @Override
  public String unconscious(Actor actor,GameMap map) {
    if(Math.random() <=  0.30){
      map.locationOf(this).addItem(new RefreshingFlask());
    }

    if (Math.random() <= 0.20){
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(100));
    return super.unconscious(map);
  }


}

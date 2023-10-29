package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.items.Runes;

/**
 * A specialized village-themed enemy class, representing a Hollow Soldier in the game.
 * Extends the VillageEnemy class and is part of the village-themed enemy group.
 *
 * The Hollow Soldier is a formidable village enemy with unique characteristics and behaviors.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 */
public class HollowSoldier extends Enemy {

  /**
   * Constructor for creating a Hollow Soldier.
   * Initializes the Hollow Soldier with its name, display character, hit points, and runes dropped when defeated.
   */
  public HollowSoldier() {
    super("Hollow Soldier", '&', 200, new Runes(100));
    int thirdPriority = 999;
    this.behaviours.put(thirdPriority, new WanderBehaviour());
  }

  /**
   * Get the intrinsic weapon of the Hollow Soldier.
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new IntrinsicWeapon instance representing the Hollow Soldier's whacks.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(50, "whacks", 50);
  }

  /**
   * Method that can be executed when the Hollow Soldier is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator that caused the Hollow Soldier to fall unconscious.
   * @param map   The GameMap where the Hollow Soldier fell unconscious.
   * @return A string describing what happened when the Hollow Soldier is unconscious.
   */
  @Override
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.30) {
      map.locationOf(this).addItem(new RefreshingFlask());
    }

    if (Math.random() <= 0.20) {
      map.locationOf(this).addItem(new HealingVial());
    }
    return super.unconscious(actor, map);
  }
}

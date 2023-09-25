package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.HealingVial;
import game.items.Key;

/**
 * Class representing the WanderingUndead.
 */
public class WanderingUndead extends Enemy {

  /**
   * Constructor.
   */
  public WanderingUndead() {
    super("Wandering Undead", 't', 100);
  }

  /**
   * create a individual intrinsic weapon for Wandering Undead
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return a new Intrinsic Weapon
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(30, "whacks", 50);
  }

  /**
   * Method that can be executed when the Wandering Undead is unconscious due to the action of another actor
   * @param actor the perpetrator
   * @param map where the Wandering Undead fell unconscious
   * @return a string describing what happened when the Wandering Undead is unconscious
   */
  @Override
  public String unconscious(Actor actor,GameMap map) {
    if (Math.random() <= 0.25) {
      map.locationOf(this).addItem(new Key());
    }

    if (Math.random() <= 0.20) {
      map.locationOf(this).addItem(new HealingVial());
    }

    return super.unconscious(map);
  }


}

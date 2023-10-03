package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Key;
import game.items.Runes;

/**
 * Class representing the Wandering Undead, a type of Enemy actor in the game.
 */
public class WanderingUndead extends Enemy {

  /**
   * Constructor to create a Wandering Undead enemy.
   */
  public WanderingUndead() {
    super("Wandering Undead", 't', 100);
  }

  /**
   * Creates an individual intrinsic weapon for the Wandering Undead.
   * Overrides Actor.getIntrinsicWeapon().
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new Intrinsic Weapon for the Wandering Undead.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(30, "whacks", 50);
  }

  /**
   * Method that can be executed when the Wandering Undead is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator who caused the Wandering Undead to become unconscious.
   * @param map   The GameMap where the Wandering Undead fell unconscious.
   * @return A string describing what happened when the Wandering Undead is unconscious.
   */
  @Override
  public String unconscious(Actor actor,GameMap map) {
    if (Math.random() <= 0.25) {
      map.locationOf(this).addItem(new Key());
    }

    if (Math.random() <= 0.20) {
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(50));
    return super.unconscious(map);
  }


}

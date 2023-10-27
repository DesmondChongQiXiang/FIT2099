package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.items.HealingVial;
import game.items.Key;
import game.items.Runes;

/**
 * A specialized village-themed enemy class, representing a Wandering Undead in the game.
 * Extends the VillageEnemy class and is part of the village-themed enemy group.
 *
 * The Wandering Undead is a menacing village enemy with unique characteristics and behaviors.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 */
public class WanderingUndead extends Enemy {
  /**
   * Constructor for creating a Wandering Undead.
   * Initializes the Wandering Undead with its name, display character, hit points, and runes dropped when defeated.
   */
  public WanderingUndead() {
    super("Wandering Undead", 't', 100, new Runes(50));
    int thirdPriority = 999;
    this.behaviours.put(thirdPriority, new WanderBehaviour());
  }

  /**
   * Get the intrinsic weapon of the Wandering Undead.
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new IntrinsicWeapon instance representing the Wandering Undead's whacks.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(30, "whacks", 50);
  }

  /**
   * Method that can be executed when the Wandering Undead is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator that caused the Wandering Undead to fall unconscious.
   * @param map   The GameMap where the Wandering Undead fell unconscious.
   * @return A string describing what happened when the Wandering Undead is unconscious.
   */
  @Override
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.25) {
      map.locationOf(this).addItem(new Key());
    }

    if (Math.random() <= 0.20) {
      map.locationOf(this).addItem(new HealingVial());
    }
    return super.unconscious(actor, map);
  }
}


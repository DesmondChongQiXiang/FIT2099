package game.actors.enemies.villageenemy;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.Enemy;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Key;
import game.items.Runes;
import game.spawners.Spawner;

public class WanderingUndead extends VillageEnemy {
  public static Spawner<WanderingUndead> SPAWNER = new Spawner<>() {
    @Override
    public WanderingUndead spawn() {
      return new WanderingUndead();
    }
  };
  /**
   * Constructor.
   */
  public WanderingUndead() {
    super("Wandering Undead", 't', 100,50);
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
   * Method that can be executed when the actor is unconscious due to the action of another actor
   * @param actor the perpetrator
   * @param map where the actor fell unconscious
   * @return a string describing what happened when the actor is unconscious
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

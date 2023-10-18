package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.HealingVial;
import game.items.Runes;
import game.spawners.Spawner;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

/**
 * A specialized forest-themed enemy class, representing a Forest Keeper in the game.
 * Extends the ForestEnemy class and implements the WeatherControllable interface.
 *
 * The ForestKeeper is a powerful enemy in the forest-themed game, with unique characteristics and behaviors.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 * @see WeatherControllable
 */
public class ForestKeeper extends FollowEnemy implements WeatherControllable{

  /**
   * Spawner for generating instances of the ForestKeeper.
   */
  public static Spawner<ForestKeeper> SPAWNER = new Spawner<>() {
    @Override
    public ForestKeeper spawn() {
      return new ForestKeeper();
    }
  };

  /**
   * Constructor for creating a Forest Keeper.
   * Initializes the Forest Keeper with its name, display character, hit points, and runes dropped when defeated.
   */
  public ForestKeeper() {
    super("Forest Keeper", '8', 125, new Runes(50));
  }

  /**
   * Get the intrinsic weapon of the Forest Keeper.
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new IntrinsicWeapon instance representing the Forest Keeper's punches.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(25, "punches", 75);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator that caused the Forest Keeper to fall unconscious.
   * @param map   The GameMap where the Forest Keeper fell unconscious.
   * @return A string describing what happened when the Forest Keeper is unconscious.
   */
  @Override
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.20) {
      map.locationOf(this).addItem(new HealingVial());
    }
    return super.unconscious(actor, map);
  }

  /**
   * Update the behavior of the Forest Keeper based on the current weather conditions.
   * This method is called when the game's weather changes.
   *
   * @param weather The current weather condition.
   * @param display The Display object used to output messages.
   */
  @Override
  public void updateWeatherMode(Weather weather, Display display) {
    if (weather == Weather.RAINY) {
      this.heal(10);
      display.println(this + " feels rejuvenated.");
    }
  }
}


package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.items.HealingVial;
import game.items.Runes;
import game.weathers.Weather;
import game.weathers.WeatherControllable;

/**
 * A specialized forest-themed enemy class, representing a Red Wolf in the game.
 * Extends the ForestEnemy class and implements the WeatherControllable interface.
 *
 * The RedWolf is a dangerous forest enemy with unique characteristics and behaviors.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 * @see WeatherControllable
 */
public class RedWolf extends FollowEnemy implements WeatherControllable {
  /**
   * Constructor for creating a Red Wolf.
   * Initializes the Red Wolf with its name, display character, hit points, and runes dropped when defeated.
   */
  public RedWolf() {
    super("Red Wolf", 'r', 25, new Runes(25));
    this.behaviours.put(999, new WanderBehaviour());
  }

  /**
   * Get the intrinsic weapon of the Red Wolf.
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return A new IntrinsicWeapon instance representing the Red Wolf's bites.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(15, "bites", 80);
  }

  /**
   * Method that can be executed when the Red Wolf is unconscious due to the action of another actor.
   *
   * @param actor The perpetrator that caused the Red Wolf to fall unconscious.
   * @param map   The GameMap where the Red Wolf fell unconscious.
   * @return A string describing what happened when the Red Wolf is unconscious.
   */
  @Override
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.10) {
      map.locationOf(this).addItem(new HealingVial());
    }
    return super.unconscious(actor, map);
  }

  /**
   * Update the behavior of the Red Wolf based on the current weather conditions.
   * This method is called when the game's weather changes.
   *
   * @param weather The current weather condition.
   * @param display The Display object used to output messages.
   */
  @Override
  public void updateWeatherMode(Weather weather, Display display) {
    if (weather == Weather.SUNNY) {
      this.updateDamageMultiplier(3);
      display.println(this + " is becoming more aggressive.");
    } else if (weather == Weather.RAINY) {
      this.updateDamageMultiplier(1);
      display.println(this + " is becoming less aggressive.");
    }
  }
}


package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Runes;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

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
public class RedWolf extends Enemy implements WeatherControllable {
  /**
   * Constructor for creating a Red Wolf.
   * Initializes the Red Wolf with its name, display character, hit points, and runes dropped when defeated.
   */
  public RedWolf() {
    super("Red Wolf", 'r', 25, new Runes(25));
    int thirdPriority = 999;
    this.behaviours.put(thirdPriority, new WanderBehaviour());
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
    WeatherManager.getInstance().removeWeatherControllable(this);
    return super.unconscious(actor, map);
  }

  @Override
  public String unconscious(GameMap map) {
    WeatherManager.getInstance().removeWeatherControllable(this);
    return super.unconscious(map);
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


  /**
   * Determine the allowable actions that can be performed on this Forest Watcher.
   * Red Wolf can follow actors with HOSTILE_TO_ENEMY capability and attack them.
   *
   * @param otherActor The Actor that might be performing an attack or action.
   * @param direction  A string representing the direction of the other Actor.
   * @param map        The current GameMap.
   * @return A list of actions that the Forest Watcher is allowed to execute or perform on the current actor.
   */
  @Override
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
    ActionList actions = new ActionList();
    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
      // Add a FollowBehaviour to follow the hostile actor.
      int secondPriority = 998;
      this.behaviours.put(secondPriority, new FollowBehaviour(otherActor));
      // Add an AttackAction to attack the hostile actor.
      actions.add(new AttackAction(this, direction));
    }
    return actions;
  }

  @Override
  public void reset(Location location) {
    WeatherManager.getInstance().removeWeatherControllable(this);
    super.reset(location);
  }
}


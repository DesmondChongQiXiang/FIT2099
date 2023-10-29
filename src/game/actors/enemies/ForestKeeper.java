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
public class ForestKeeper extends Enemy implements WeatherControllable {
  /**
   * Constructor for creating a Forest Keeper.
   * Initializes the Forest Keeper with its name, display character, hit points, and runes dropped when defeated.
   */
  public ForestKeeper() {
    super("Forest Keeper", '8', 125, new Runes(50));
    int thirdPriority = 999;
    this.behaviours.put(thirdPriority, new WanderBehaviour());
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
    WeatherManager.getInstance().removeWeatherControllable(this);
    return super.unconscious(actor, map);
  }

  @Override
  public String unconscious(GameMap map) {
    WeatherManager.getInstance().removeWeatherControllable(this);
    return super.unconscious(map);
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

  /**
   * Determine the allowable actions that can be performed on this Forest Watcher.
   * Forest Keeper can follow actors with HOSTILE_TO_ENEMY capability and attack them.
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


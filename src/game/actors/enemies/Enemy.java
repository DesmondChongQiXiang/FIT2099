package game.actors.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class for all the enemies present in the game.
 *
 * @author Yoong Qian Xin
 */
public abstract class Enemy extends Actor {
  private Map<Integer, Behaviour> behaviours = new HashMap<>();
  private double spawnRate;

  /**
   * Constructor.
   * The Enemy should prioritise the AttackBehaviour and put it in the front of the behaviours list.
   * So that if the Player is nearby, the Enemy can attack them.
   *
   * @param name        the name of the Enemy
   * @param displayChar the character that will represent the Enemy in the display
   * @param hitPoints   the Enemy's starting hit points
   */
  public Enemy(String name, char displayChar, int hitPoints) {
    super(name, displayChar, hitPoints);
    this.behaviours.put(999, new WanderBehaviour());
    setSpawnRate(spawnRate);
  }

  /**
   * Spawn the instance of an enemy
   *
   * @return an enemy type actor
   */
  public abstract Enemy spawnMethod();

  /**
   * The enemy can be attacked by any actor that has the status of HOSTILE_TO_ENEMY.
   *
   * @param otherActor the Actor that might be performing attack
   * @param direction  String representing the direction of the other Actor
   * @param map        current GameMap
   *
   * @return A list of actions that is allowed to be executed/performed on the current actor.
   */
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
    ActionList actions = new ActionList();
    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
      actions.add(new AttackAction(this, direction));
    }

    return actions;
  }

  /**
   * A getter to get the map of behaviours of enemies.
   */
  public Map<Integer, Behaviour> getBehaviours() {
    return behaviours;
  }

  /**
   * To get the spawn rate of the enemy.
   *
   * @return The spawn rate of the enemy.
   */
  public double getSpawnRate() {
    return this.spawnRate;
  }

  /**
   * To set the spawn rate of the enemy.
   *
   * @param spawnRate The spawn rate of the enemy.
   */
  public void setSpawnRate(double spawnRate) {
    this.spawnRate = spawnRate;
  }


}

package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.RefreshingFlask;

/**
 * A class that represents an enemy called Red Wolf.
 *
 * @author Yoong Qian Xin
 */
public class RedWolf extends Enemy {

  /**
   * Constructor.
   */
  public RedWolf() {
    super("Red Wolf", '8', 25);
    setSpawnRate(0.30);
  }

  /**
   * Set the intrinsic weapon of the Red Wolf.
   *
   * @return the intrinsic weapon of Red Wolf.
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(15, "bites", 80);
  }

  /**
   * Spawn the Red Wolf instance
   *
   * @return a new spawned Red Wolf instance
   */
  public Enemy spawnInstance() {
    return new RedWolf();
  }

  /**
   * The Red Wolf action in each turn.
   *
   * @param actions    collection of possible Actions for this Red Wolf
   * @param lastAction The Action this Red Wolf took last turn. Can do interesting things in
   *                   conjunction with Action.getNextAction()
   * @param map        the map containing the Actor
   * @param display    the I/O object to which messages may be written
   *
   * @return The action to be executed.
   */
  public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
    Location actor = map.locationOf(this);

    for (Exit exit: actor.getExits()) {
      Location destination = exit.getDestination();

      // checks if exit-location contains target actor and if player has a status of hostile to enemy
      if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
        getBehaviours().put(0, new AttackBehaviour(destination.getActor(), exit.getName()));
        getBehaviours().put(2, new FollowBehaviour(destination.getActor()));  // only enemies native to the Ancient Forest can follow the player
      }
    }

    for (Behaviour behaviour : getBehaviours().values()){
      Action action = behaviour.getAction(this, map);
      if (action != null) {
        return action;
      }
    }
    return new DoNothingAction();
  }

  /**
   * Method that can be executed when the Red Wolf is unconscious due to natural causes or accident.
   *
   * @param map where the Red Wolf fell unconscious
   *
   * @return a string describing what happened when the Red Wolf is unconscious
   */
  public String unconscious(GameMap map) {
    return super.unconscious(map);
  }

  /**
   * Method that can be executed when the Red Wolf is unconscious due to the action of another actor.
   *
   * @param actor the perpetrator
   * @param map where the Red Wolf fell unconscious
   * @return a string describing what happened when the Red Wolf is unconscious
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.10){
      map.locationOf(this).addItem(new HealingVial());
    }

    return super.unconscious(actor, map);
  }


}



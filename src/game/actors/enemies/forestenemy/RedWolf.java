package game.actors.enemies.forestenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.Runes;

public class RedWolf extends ForestEnemy {

  /**
   * Constructor.
   */
  public RedWolf(){

    super("Red Wolf", 'r', 25);
  }

  /**
   * create a individual intrinsic weapon for Red Wolf
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return a new Intrinsic Weapon
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(15, "bites", 80);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
   *
   * @param actor the perpetrator
   * @param map where the Forest Keeper fell unconscious
   * @return a string describing what happened when the Forest Keeper is unconscious
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.10){
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(25));
    return super.unconscious(actor, map);
  }

  @Override
  public void sunnyMode(){
    this.updateDamageMultiplier(3);
  }

  @Override
  public void rainyMode(){
    this.updateDamageMultiplier(1);
  }
}
package game.actors.enemies.forestenemy;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.HealingVial;
import game.items.Runes;
import game.spawners.Spawner;
import game.weathers.WeatherControllable;

public class ForestKeeper extends ForestEnemy {
  public static Spawner<ForestKeeper> SPAWNER = new Spawner<>() {
    @Override
    public ForestKeeper spawn() {
      return new ForestKeeper();
    }
  };
  /**
   * Constructor.
   */
  public ForestKeeper(){
    super("Forest Keeper", '8', 125);
  }


  /**
   * create a individual intrinsic weapon for Forest Keeper
   *
   * Overrides Actor.getIntrinsicWeapon()
   *
   * @see Actor#getIntrinsicWeapon()
   * @return a new Intrinsic Weapon
   */
  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(25, "punches", 75);
  }

  /**
   * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
   *
   * @param actor the perpetrator
   * @param map where the Forest Keeper fell unconscious
   * @return a string describing what happened when the Forest Keeper is unconscious
   */
  public String unconscious(Actor actor, GameMap map) {
    if (Math.random() <= 0.20){
      map.locationOf(this).addItem(new HealingVial());
    }

    map.locationOf(this).addItem(new Runes(50));
    return super.unconscious(actor, map);
  }

  @Override
  public void sunnyMode(){

  }

  @Override
  public void rainyMode(){
    this.heal(10);
  }
}

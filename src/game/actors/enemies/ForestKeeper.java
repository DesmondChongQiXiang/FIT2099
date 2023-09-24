package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.grounds.enemygrounds.EnemyGround;
import game.items.HealingVial;
import game.items.RefreshingFlask;

public class ForestKeeper extends Enemy {
    /**
     * Constructor.
     */
    public ForestKeeper(){
        super("Forest Keeper", '8', 125);
    }

    /**
     * create a individual intrinsic weapon for Hollow Soldier
     *
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @see Actor#getIntrinsicWeapon()
     * @return a new Intrinsic Weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(25,"punches",75);
    }
}

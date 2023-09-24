package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class RedWolf extends Enemy{
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
        return new IntrinsicWeapon(15,"bites",80);
    }
}

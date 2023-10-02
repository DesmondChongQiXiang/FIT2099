package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Ability;

public class ForestWatcher extends Enemy {
    /**
     * Constructor.
     */
    public ForestWatcher() {
        super("Forest Watcher", 'Y', 2000);
        this.addCapability(Ability.ENTER_VOID);
    }

    /**
     * create a individual intrinsic weapon for Forest Watcher
     * <p>
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @return a new Intrinsic Weapon
     * @see Actor#getIntrinsicWeapon()
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "slaps", 25);
    }
}

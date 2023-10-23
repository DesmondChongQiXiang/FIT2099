package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Ability;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.items.Runes;

public class EldentreeGuardian extends FollowEnemy{
    public EldentreeGuardian() {
        super("Eldentree Guardian", 'e', 250, new Runes(250));
        this.addCapability(Ability.ENTER_VOID);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(50, "attack", 80);
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        if (Math.random() <= 0.25) {
            map.locationOf(this).addItem(new HealingVial());
        }
        if (Math.random() <= 0.15) {
            map.locationOf(this).addItem(new RefreshingFlask());
        }
        return super.unconscious(actor, map);
    }
}

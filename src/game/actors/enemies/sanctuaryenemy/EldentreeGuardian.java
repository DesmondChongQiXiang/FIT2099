package game.actors.enemies.sanctuaryenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Status;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import game.spawners.Spawner;

public class EldentreeGuardian extends SanctuaryEnemy{

    /**
     * Spawner for generating instances of the EldentreeGuardian.
     */
    public static Spawner<EldentreeGuardian> SPAWNER = new Spawner<>() {
        @Override
        public EldentreeGuardian spawn() {
            return new EldentreeGuardian();
        }
    };

    public EldentreeGuardian() {
        super("Eldentree Guardian", 'e', 250, 250);
        this.behaviours.put(999, new WanderBehaviour());
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

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add a FollowBehaviour to follow the hostile actor.
            this.behaviours.put(998, new FollowBehaviour(otherActor));
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

}

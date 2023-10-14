package game.actors.enemies.sanctuaryenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.capabilities.Status;
import game.items.BloodBerry;
import game.spawners.Spawner;

public class LivingBranch extends SanctuaryEnemy {

    /**
     * Spawner for generating instances of the LivingBranch.
     */
    public static Spawner<LivingBranch> SPAWNER = new Spawner<>() {
        @Override
        public LivingBranch spawn() {
            return new LivingBranch();
        }
    };
    /**
     * Constructor for creating an enemy actor.
     */
    public LivingBranch() {
        super("Living Branch", '?', 75, 500);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(250, "attack", 90);
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        if (Math.random() <= 0.50) {
            map.locationOf(this).addItem(new BloodBerry());
        }
        return super.unconscious(actor, map);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

}

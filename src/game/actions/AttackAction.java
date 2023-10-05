package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * An Action that allows an actor to attack another actor.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of the incoming attack (only used for display purposes).
     */
    private String direction;

    /**
     * The weapon used for the attack.
     */
    private Weapon weapon;

    /**
     * Constructor for AttackAction.
     *
     * @param target    The Actor to attack.
     * @param direction The direction where the attack should be performed (only used for display purposes).
     * @param weapon    The weapon used for the attack.
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor for AttackAction with intrinsic weapon as the default.
     *
     * @param target    The Actor to attack.
     * @param direction The direction where the attack should be performed (only used for display purposes).
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Allows the Actor to attack the target.
     * Overrides Action.execute()
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the Action suitable for the menu.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        if (!(Math.random() * 100 <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += "\n" + target.unconscious(actor, map);
        }

        return result;


    }
    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player attacks enemy at (13, 6) with weapon"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }


}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * A custom Action class that represents an attack action performed by an actor.
 * This action allows an actor to attack another actor using a specified weapon or their intrinsic weapon.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor for the AttackAction class.
     *
     * @param target     The Actor to attack.
     * @param direction  The direction where the attack should be performed (for display purposes).
     * @param weapon     The weapon used for the attack (can be null for intrinsic weapon).
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor for the AttackAction class with intrinsic weapon as the default.
     *
     * @param target     The Actor to attack.
     * @param direction  The direction where the attack should be performed (for display purposes).
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Executes the attack action, including calculating hit success, damage, and the result of the attack.
     *
     * @param actor The actor performing the attack.
     * @param map   The GameMap on which the attack is performed.
     * @return A string describing the outcome of the attack (e.g., "Bob hits the monster for 10 damage.").
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
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
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "Bob attacks the monster at north with Sword").
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}

package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.WeaponSkill;

/**
 * An Action that activate weapon special skill
 */
public class ActivateSkillAction extends Action {
    /**
     * Weapon used to activate the special skill of it
     */
    private final WeaponSkill weapon;

    /**
     * Constructor to create an Action that will activate the special skill of the weapons
     *
     * @param weapon the weapon used to activate the skill
     */
    public ActivateSkillAction(WeaponSkill weapon) {
        this.weapon = weapon;
    }

    /**
     * Allow the Actor to activate his/her weapon skill
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return weapon.activateSkill(actor);
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player activates the skill of Broadsword"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " activates the skill of " + weapon;
    }
}

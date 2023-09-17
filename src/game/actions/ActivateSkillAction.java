package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.weapons.WeaponSkill;

/**
 * A custom Action class that represents the activation of a weapon skill by an actor.
 * This action allows an actor to use a specific weapon skill during gameplay.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class ActivateSkillAction extends Action {

    private WeaponSkill weaponItem;

    /**
     * Constructor for the ActivateSkillAction class.
     *
     * @param weaponSkill The weapon skill to be activated.
     */
    public ActivateSkillAction(WeaponSkill weaponSkill) {
        this.weaponItem = weaponSkill;
    }

    /**
     * Executes the activation of the weapon skill by the actor.
     *
     * @param actor The actor performing the action.
     * @param map   The GameMap on which the action is performed.
     * @return A string describing the outcome of the skill activation.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return weaponItem.activateFocusSkill(actor);
    }

    /**
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "John activates the skill of Fireball").
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s activates the skill of %s",actor,weaponItem);
    }
}

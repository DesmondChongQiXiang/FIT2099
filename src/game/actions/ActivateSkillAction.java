package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An Action that activates a weapon's special skill.
 * This action allows an actor to use a weapon's special skill on a target actor or themselves.
 *
 * @author : MA_AppliedSession1_Group7
 */
public class ActivateSkillAction extends Action {
    private Actor target;

    /**
     * The weapon used to activate the special skill.
     */
    private final ActiveSkill weapon;

    /**
     * Constructor to create an Action that will activate the special skill of the weapon.
     *
     * @param weapon The weapon used to activate the skill.
     */
    public ActivateSkillAction(ActiveSkill weapon) {
        this.weapon = weapon;
    }

    /**
     * Constructor to create an Action that will activate the special skill of the weapon on a specific target actor.
     *
     * @param weapon The weapon used to activate the skill.
     * @param target The target actor on which the skill will be activated.
     */
    public ActivateSkillAction(ActiveSkill weapon, Actor target){
        this.weapon = weapon;
        this.target = target;
    }

    /**
     * Allow the Actor to activate their weapon skill.
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A description of the Action suitable for the menu.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return weapon.activateSkill(actor, target, map);
    }

    /**
     * Returns a description of this action suitable for display in the menu.
     *
     * @param actor The actor performing the action.
     * @return A String describing the action, e.g., "Player activates the skill of Broadsword."
     */
    @Override
    public String menuDescription(Actor actor) {
        String ret = actor + " activates the skill of " + weapon;
        if (target != null){
            ret += " on " + target;
        }
        return ret;
    }
}
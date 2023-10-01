package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Represent a weapon that have a special skill
 */
public interface ActiveSkill {

    /**
     * Activates the special skill of the weapon.
     *
     * @param owner The actor who owns the weapon and is activating the skill.
     * @param target The target actor who will be affected by the skill.
     * @param map The game map where the action takes place.
     * @return A string describing the outcome of activating the skill.
     */
    String activateSkill(Actor owner, Actor target, GameMap map);

    /**
     * Consumes the stamina of the actor who is activating the skill.
     *
     * @param owner The actor who owns the weapon and is activating the skill.
     */
    void staminaConsumedByActivateSkill(Actor owner);

    /**
     * Executes the skill action, which involve attacking, moving etc
     *
     * @param owner The actor who owns the weapon and is activating the skill.
     * @param target The target actor who will be affected by the skill.
     * @param map The game map where the action takes place.
     * @return A string describing the outcome of the skill action.
     */
    String skillAction(Actor owner, Actor target, GameMap map);
}

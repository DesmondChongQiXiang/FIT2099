package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Represent a weapon that have a special skill
 *
 * @author : MA_AppliedSession1_Group7
 */
public interface ActiveSkill {

    /**
     * Activates the special skill of the weapon.
     *
     * @param owner  The actor who owns the weapon and is activating the skill.
     * @param target The target actor who will be affected by the skill.
     * @param map    The game map where the action takes place.
     * @return A string describing the outcome of activating the skill.
     *
     * @throws NullPointerException     if owner, target, or map is null
     * @throws IllegalArgumentException if the skill cannot be activated for some reason
     *
     * Example:
     * "The fireball scorches the enemy for 15 damage points."
     */
    String activateSkill(Actor owner, Actor target, GameMap map);

    /**
     * Consumes the stamina of the actor who is activating the skill.
     *
     * @param owner The actor who owns the weapon and is activating the skill.
     *
     * @throws NullPointerException if owner is null
     *
     * Example:
     * "The player's stamina is reduced by 10 points."
     */
    boolean staminaConsumedByActivateSkill(Actor owner);

    /**
     * Executes the skill action, which involves attacking, moving, etc.
     *
     * @param owner  The actor who owns the weapon and is activating the skill.
     * @param target The target actor who will be affected by the skill.
     * @param map    The game map where the action takes place.
     * @return A string describing the outcome of the skill action.
     *
     * @throws NullPointerException     if owner, target, or map is null
     * @throws IllegalArgumentException if the skill action fails for some reason
     *
     * Example:
     * "The player lunges at the enemy with lightning speed, dealing 20 damage points."
     */
    String skillAction(Actor owner, Actor target, GameMap map);
}

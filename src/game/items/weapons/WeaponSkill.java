package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing a skill that can be activated by a weapon.
 *
 * This interface defines a method for activating the skill, which may provide special abilities or effects when
 * used in combination with a specific weapon.
 *
 * @author Ong Chong How
 *
 * @see game.items.weapons.BroadSword
 *
 * @version 1.0
 */
public interface WeaponSkill {

    /**
     * Activates the focus skill associated with the weapon, providing special abilities or effects.
     *
     * @param actor The actor using the weapon skill.
     * @return A message indicating the activation of the skill or its effects.
     */
    String activateFocusSkill(Actor actor);

}

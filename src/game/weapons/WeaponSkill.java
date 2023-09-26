package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Represent a weapon that has a special skill
 */
public interface WeaponSkill {
    /**
     * @param actor the actor that activates the weapon skill
     */
    String activateSkill(Actor actor);
    boolean hasSpecialSkill();

}

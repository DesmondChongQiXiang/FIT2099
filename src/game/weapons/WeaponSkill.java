package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
/**
 * Represent a weapon that have a special skill
 */
public interface WeaponSkill {
    /**
     * @param actor the actor that activate the weapon skill
     */
    String activateSkill(Actor actor);
}

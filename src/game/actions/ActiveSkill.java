package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Represent a weapon that have a special skill
 */
public interface ActiveSkill {

    /**
     * @param owner the owner that activate the weapon skill
     */
    String activateSkill(Actor owner, Actor target, GameMap map);


}

package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;

/**
 * Represent a weapon that have a special skill
 */
public interface ActiveSkill {

    /**
     * @param actor the actor that activate the weapon skill
     */
    String activateSkill(Actor actor, Actor target, ActorLocationsIterator actorLocations);


}

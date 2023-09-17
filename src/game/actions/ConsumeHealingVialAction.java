package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.collections.HealingVial;

/**
 * A custom Action class that represents an actor consuming a Healing Vial to restore stamina points.
 * This action allows an actor to use a Healing Vial to regain stamina points.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class ConsumeHealingVialAction extends Action {

    /**
     * The HealingVial to be consumed.
     */
    private HealingVial healingVial;

    /**
     * Constructor for the ConsumeHealingVialAction class.
     *
     * @param healingVial The HealingVial to be consumed.
     */
    public ConsumeHealingVialAction(HealingVial healingVial) {
        this.healingVial = healingVial;
    }

    /**
     * Executes the consumption of the Healing Vial by the actor.
     *
     * @param actor The actor consuming the Healing Vial.
     * @param map   The GameMap on which the action is performed.
     * @return A string describing the outcome of consuming the Healing Vial.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int points = healingVial.consume(actor);
        return String.format("%s consumes %s and %s restores the stamina of %s by %d points",actor,healingVial,healingVial,actor,points);
    }

    /**
     * Provides a description of the action for use in menus and user interfaces.
     *
     * @param actor The actor for whom the menu description is generated.
     * @return A formatted string describing the action (e.g., "John consumes Healing Vial").
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s consumes %s",actor,healingVial);
    }
}

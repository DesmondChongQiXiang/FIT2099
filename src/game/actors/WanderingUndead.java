package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utilities.ProbabilityGenerator;
import game.items.HealingVial;
import game.items.Key;

public class WanderingUndead extends Enemy {
    /**
     * Constructor.
     *
     */
    public WanderingUndead() {
        super("Wandering Undead", 't', 100);
    }

    /**
     * create a individual intrinsic weapon for Wandering Undead
     *
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @see Actor#getIntrinsicWeapon()
     * @return a new Intrinsic Weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30,"whacks",50);
    }

    /**
     * Method that can be executed when the actor is unconscious due to the action of another actor
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
    @Override
    public String unconscious(Actor actor,GameMap map) {
        if (ProbabilityGenerator.generateProbability(25)) {
            map.locationOf(this).addItem(new Key());
        }
        if (ProbabilityGenerator.generateProbability(20)) {
            map.locationOf(this).addItem(new HealingVial());
        }
        return super.unconscious(map);
    }
}

package game.actors.enemies;

import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.collections.HealingVial;
import game.items.collections.OldKey;

/**
 * A specific type of enemy representing a Wandering Undead in the game.
 * Wandering Undead have unique attributes, behavior, and loot drops when defeated.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class WanderingUndead extends Enemy {

    /**
     * Constructor for the WanderingUndead class.
     */
    public WanderingUndead() {
        super("Wandering Undead", 't', 100);
    }

    /**
     * Handles the unconscious state of the Wandering Undead.
     * This method sets the Wandering Undead's health to 0, removes it from the map,
     * and has a chance to drop an Old Key and a Healing Vial as loot.
     *
     * @param actor The actor interacting with the Wandering Undead.
     * @param map   The game map from which the Wandering Undead is removed.
     * @return A message indicating the outcome of the unconscious state.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE,0);
        new Display().println(new DoNothingAction().execute(this,map));

        // Add loot drops with certain probabilities
        if(Math.random() <= 0.25){
            map.locationOf(this).addItem(new OldKey("Old Key",'-',true));
        }
        if(Math.random() <= 0.2){
            map.locationOf(this).addItem(new HealingVial("Healing Vial",'a',true));
        }
        map.removeActor(this);
        return super.unconscious(map);
    }

    /**
     * Retrieves the intrinsic weapon of the Wandering Undead.
     * Wandering Undead have a specific intrinsic weapon for attacks.
     *
     * @return The intrinsic weapon of the Wandering Undead.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30,"attacks",50);
    }
}

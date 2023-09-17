package game.actors.enemies;

import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.collections.HealingVial;
import game.items.collections.RefreshingFlask;

/**
 * A specific type of enemy representing a Hollow Soldier in the game.
 * Hollow Soldiers have unique attributes, behavior, and loot drops when defeated.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class HollowSoldier extends Enemy {

    /**
     * Constructor for the HollowSoldier class.
     */
    public HollowSoldier(){
        super("Hollow Soldier", '&', 200);
    }

    /**
     * Handles the unconscious state of the Hollow Soldier.
     * This method sets the Hollow Soldier's health to 0, removes it from the map,
     * and has a chance to drop Healing Vials and Refreshing Flasks as loot.
     *
     * @param actor The actor interacting with the Hollow Soldier.
     * @param map   The game map from which the Hollow Soldier is removed.
     * @return A message indicating the outcome of the unconscious state.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE,0);
        new Display().println(new DoNothingAction().execute(this,map));

        // Add loot drops with certain probabilities
        if(Math.random() <= 0.2){
            map.locationOf(this).addItem(new HealingVial("Healing Vial",'a',true));
        }
        if(Math.random() <= 0.3){
            map.locationOf(this).addItem(new RefreshingFlask("Refreshing Flask",'u',true));
        }
        map.removeActor(this);
        return super.unconscious(map);
    }

    /**
     * Retrieves the intrinsic weapon of the Hollow Soldier.
     * Hollow Soldiers have a specific intrinsic weapon for attacks.
     *
     * @return The intrinsic weapon of the Hollow Soldier.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(50,"attacks",50);
    }
}

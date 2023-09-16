package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

import game.behaviours.AttackBehaviour;
import game.items.HealingVial;
import game.items.OldKey;
import game.utils.Status;

/**
 * A class that represents an enemy called Wandering Undead.
 * The graveyard can spawn this enemy with a 25% chance at every turn of the game.
 *
 * @author Yoong Qian Xin
 */
public class WanderingUndead extends Enemy {

    /**
     * Constructor.
     */
    public WanderingUndead() {
        super("Wandering Undead", 't', 100);
        this.setSpawnRate(0.25);
    }

    /**
     * Set the intrinsic weapon of the WanderingUndead.
     *
     * @return the intrinsic weapon of WanderingUndead.
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "whacks", 50);
    }

    /**
     * Spawn the WanderingUndead instance
     *
     * @return a new spawned WanderingUndead instance
     */
    @Override
    public Enemy spawnMethod() {
        return new WanderingUndead();
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this WanderingUndead
     * @param lastAction The Action this WanderingUndead took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location actor = map.locationOf(this);

        for (Exit exit: actor.getExits()) {
            Location destination = exit.getDestination();

            // checks if exit-location contains target actor and if player has a status of hostile to enemy
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                    getBehaviours().put(0, new AttackBehaviour(destination.getActor(), exit.getName()));
                }
            }

        for (Behaviour behaviour : getBehaviours().values()){
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * Method that can be executed when the WanderingUndead is unconscious due to natural causes or accident.
     *
     * @param map where the WanderingUndead fell unconscious
     * @return a string describing what happened when the WanderingUndead is unconscious
     */
    public String unconscious(GameMap map) {
        return super.unconscious(map);
    }

    /**
     * Method that can be executed when the WanderingUndead is unconscious due to the action of another actor.
     *
     * @param actor the perpetrator
     * @param map where the WanderingUndead fell unconscious
     *
     * @return a string describing what happened when the WanderingUndead is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        if(Math.random() <= this.getSpawnRate()){
            map.locationOf(this).addItem(new OldKey());
        }

        if(Math.random() <= 0.20) {
            map.locationOf(this).addItem(new HealingVial());
        }

        return super.unconscious(actor, map);
    }


}

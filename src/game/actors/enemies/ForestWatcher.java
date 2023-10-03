package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Ability;
import game.grounds.Gate;
import game.items.HealingVial;
import game.items.Runes;

/**
 * Class representing the Forest Watcher, a type of Enemy actor in the game.
 */
public class ForestWatcher extends Enemy{
    /**
     * Constructor to create a Forest Watcher enemy.
     */
    public ForestWatcher(){
        super("Forest Watcher", 'Y', 2000);
        this.addCapability(Ability.ENTER_VOID);
    }

    /**
     * Creates an individual intrinsic weapon for the Forest Watcher.
     * Overrides Actor.getIntrinsicWeapon().
     *
     * @see Actor#getIntrinsicWeapon()
     * @return A new Intrinsic Weapon for the Forest Watcher.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "slaps", 25);
    }

    /**
     * Method that can be executed when the Forest Keeper is unconscious due to the action of another actor.
     *
     * @param actor the perpetrator
     * @param map where the Forest Watcher fell unconscious
     * @return a string describing what happened when the Forest Watcher is unconscious
     */
    public String unconscious(Actor actor, GameMap map) {
        map.locationOf(this).setGround(new Gate());
        map.locationOf(this).addItem(new Runes(5000));
        return super.unconscious(actor, map);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    Collection of possible Actions for this Actor.
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction().
     * @param map        The map containing the Actor.
     * @param display    The I/O object to which messages may be written.
     * @return The valid action that can be performed in that iteration or null if no valid action is found.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        map.tick();
        return new DoNothingAction();
    }
}

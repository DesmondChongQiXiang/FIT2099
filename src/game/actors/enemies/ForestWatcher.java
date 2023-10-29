package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.reset.ResetNotifiableManager;
import game.reset.ResetNotifiable;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.grounds.Gate;
import game.items.Runes;
import game.weathers.WeatherManager;


/**
 * A specialized forest-themed enemy class, representing a Forest Watcher in the game.
 * Extends the Enemy class and implements the WeatherControllable interface.
 *
 * The Forest Watcher is a powerful enemy with unique characteristics and behaviors.
 * It has the ability to control the game's weather and interact with special game elements.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Enemy
 */
public class ForestWatcher extends Enemy implements ResetNotifiable{
    private int turnCount;
    private Gate abxyverGate;
    private boolean resetRequired;

    /**
     * Constructor for creating a Forest Watcher.
     *
     * @param abxyverGate    The Gate that the Forest Watcher interacts with.
     */
    public ForestWatcher(Gate abxyverGate) {
        super("Forest Watcher", 'Y', 2000, new Runes(5000));
        int thirdPriority = 999;
        this.behaviours.put(thirdPriority, new WanderBehaviour());
        this.addCapability(Ability.ENTER_VOID);
        this.turnCount = 0;
        this.abxyverGate = abxyverGate;
        resetRequired = false;
    }

    /**
     * Get the intrinsic weapon of the Forest Watcher.
     *
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @return A new IntrinsicWeapon instance representing the Forest Watcher's slaps.
     * @see Actor#getIntrinsicWeapon()
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "slaps", 25);
    }

    /**
     * Method that can be executed when the Forest Watcher is unconscious due to the action of another actor.
     *
     * @param actor The perpetrator that caused the Forest Watcher to fall unconscious.
     * @param map   The GameMap where the Forest Watcher fell unconscious.
     * @return A string describing what happened when the Forest Watcher is unconscious.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        actor.addCapability(Status.BOSS_DEFEATED);
        map.locationOf(this).setGround(abxyverGate);
        ResetNotifiableManager.getInstance().removeResetNotifiable(this);
        ResetNotifiableManager.getInstance().registerResetNotifiable(abxyverGate);
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
        if (resetRequired){
            this.reset(map.locationOf(this));
        }
        if (turnCount % 3 == 0) {
            WeatherManager.getInstance().switchWeather(display);
        }
        WeatherManager.getInstance().controlEnemy(display);
        turnCount++;
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public void notifyReset() {
        resetRequired = true;
    }

    @Override
    public void reset(Location location) {
        this.heal(this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        resetRequired = false;
    }


    /**
     * Determine the allowable actions that can be performed on this Forest Watcher.
     * Forest Watcher can follow actors with HOSTILE_TO_ENEMY capability and attack them.
     *
     * @param otherActor The Actor that might be performing an attack or action.
     * @param direction  A string representing the direction of the other Actor.
     * @param map        The current GameMap.
     * @return A list of actions that the Forest Watcher is allowed to execute or perform on the current actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add a FollowBehaviour to follow the hostile actor.
            int secondPriority = 998;
            this.behaviours.put(secondPriority, new FollowBehaviour(otherActor));
            // Add an AttackAction to attack the hostile actor.
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}


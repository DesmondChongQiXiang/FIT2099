package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.behaviours.FollowBehaviour;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.grounds.Gate;
import game.items.Runes;

import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

import java.util.ArrayList;


public class ForestWatcher extends Enemy {

    private int turnCount;
    private WeatherManager weatherManager;
    private Gate abxyverGate;
    /**
     * Constructor.
     */
    public ForestWatcher(WeatherManager weatherManager, Gate abxyverGate) {
        super("Forest Watcher", 'Y', 2000);
        this.addCapability(Ability.ENTER_VOID);
        this.turnCount = 0;
        this.weatherManager = weatherManager;
        this.abxyverGate = abxyverGate;
    }

    /**
     * create a individual intrinsic weapon for Forest Watcher
     * <p>
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @return a new Intrinsic Weapon
     * @see Actor#getIntrinsicWeapon()
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
        map.locationOf(this).setGround(abxyverGate);
        map.locationOf(this).addItem(new Runes(5000));
        return super.unconscious(actor, map);
    }

    /**
     * Enemy can follow actor that has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of actions that is allowed to be executed/performed on the current actor.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(998, new FollowBehaviour(otherActor));
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (turnCount % 3 == 0){
            weatherManager.switchWeather(display);
        }
        weatherManager.controlEnemy(display);
        turnCount++;
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}

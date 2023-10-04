package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Status;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;
/**
 * Class representing the Enemy.
 */
public abstract class Enemy extends Actor {
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    /**
     * Constructor.
     *
     * @param name        The name of the enemy
     * @param displayChar Character to represent the enemy in the UI
     * @param hitPoints   Enemy's starting number of hitpoints
     */
    public Enemy(String name, char displayChar, int hitPoints){
        super(name,displayChar,hitPoints);
        // Priority of behaviour:  1. AttackBehaviour  2. FollowBehaviour  3. WanderBehaviour
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour());
        addCapability(Status.ENEMY);
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
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }


}

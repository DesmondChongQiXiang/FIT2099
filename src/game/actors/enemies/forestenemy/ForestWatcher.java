package game.actors.enemies.forestenemy;

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
import game.grounds.environments.forestenemyspawnableground.ForestEnemySpawnableGround;
import game.items.Runes;
import game.spawners.forestenemyspawner.ForestEnemySpawner;
import game.weathers.Weather;

import java.util.ArrayList;


public class ForestWatcher extends ForestEnemy {

    private int turnCount;
    private ArrayList<ForestEnemySpawner> forestEnemySpawnerList;
    private ArrayList<ForestEnemySpawnableGround> forestEnemySpawnableGroundList;
    private Weather currentWeather;
    /**
     * Constructor.
     */
    public ForestWatcher(ArrayList<ForestEnemySpawner> forestEnemySpawnerList, ArrayList<ForestEnemySpawnableGround> forestEnemySpawnableGroundList) {
        super("Forest Watcher", 'Y', 2000);
        this.addCapability(Ability.ENTER_VOID);
        this.turnCount = 0;
        this.forestEnemySpawnerList = forestEnemySpawnerList;
        this.forestEnemySpawnableGroundList = forestEnemySpawnableGroundList;
        this.currentWeather = Weather.SUNNY;
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
        map.locationOf(this).setGround(new Gate());
        map.locationOf(this).addItem(new Runes(5000));
        return super.unconscious(actor, map);
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
        turnCount++;
        if (turnCount % 3 == 0 && currentWeather == Weather.SUNNY) {
            currentWeather = Weather.RAINY;
            rainyMode();
        }else{
            currentWeather = Weather.SUNNY;
            sunnyMode();
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public void sunnyMode(){
        for (ForestEnemySpawner forestEnemySpawner : forestEnemySpawnerList){
            forestEnemySpawner.sunnyMode();
        }
    }

    @Override
    public void rainyMode(){
        for (ForestEnemySpawner forestEnemySpawner : forestEnemySpawnerList){
            forestEnemySpawner.rainyMode();
        }
    }
}

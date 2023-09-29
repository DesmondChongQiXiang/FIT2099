package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.ActivateSkillAction;
import game.actions.ActiveSkill;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.displays.FancyMessage;

import java.util.List;


/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *  Desmond Chong Qi Xiang
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints, int stamina, int mana) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_FLOOR);
        this.addCapability(Ability.BUYING);
        this.addAttribute(BaseActorAttributes.STAMINA, new BaseActorAttribute(stamina));
        this.addBalance(20000);
        this.addCapability(Ability.UNLOCK_GATE);

    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH,ActorAttributeOperations.UPDATE,0);
        String ret = "";
        ret += super.unconscious(actor,map);
        map.removeActor(this);
        ret += "\n" + FancyMessage.YOU_DIED;
        return ret;
    }

    @Override
    public String unconscious(GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH,ActorAttributeOperations.UPDATE,0);
        String ret = "";
        ret += new DoNothingAction().execute(this,map);
        map.removeActor(this);
        ret += "\n" + FancyMessage.YOU_DIED;
        return ret;
    }

    /**
     * create an individual intrinsic weapon for Player
     * Overrides Actor.getIntrinsicWeapon()
     *
     * @see Actor#getIntrinsicWeapon()
     * @return a new Intrinsic Weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {

        return new IntrinsicWeapon(15,"bonks",80);
    }


    /**
     * Consumes a specified amount of stamina from the player's current stamina.
     * This method decreases the player's stamina attribute by the given amount.
     *
     * @param amount The amount of stamina to be consumed.
     */
    public void consumeStamina(int amount) {
        this.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, amount);
    }

    /**
     * Retrieves the maximum stamina that the player can have.
     *
     * @return The maximum value of the player's stamina attribute.
     */
    public int getMaxStamina() {
        return this.getAttributeMaximum(BaseActorAttributes.STAMINA);
    }


    /**
         * Select and return an action to perform on the current turn.
         * @param actions    collection of possible Actions for this Actor
         * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
         * @param map        the map containing the Actor
         * @param display    the I/O object to which messages may be written
         * @return the Action to be performed
         */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        this.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, (int)(this.getAttributeMaximum(BaseActorAttributes.STAMINA)*.01f));
        if (lastAction.getNextAction() != null) {
            return lastAction.getNextAction();
        }

        display.println(this.name);
        display.println("HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        display.println("Stamina: " + this.getAttribute(BaseActorAttributes.STAMINA) + "/" + this.getAttributeMaximum(BaseActorAttributes.STAMINA));
        display.println("Runes: "+this.getBalance());

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }
}


package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.displays.FancyMessage;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor {

    /**
     * Constructor to create a Player character.
     *
     * @param name       Name to call the player in the UI.
     * @param displayChar Character to represent the player in the UI.
     * @param hitPoints  Player's starting number of hitpoints.
     * @param stamina    Player's starting stamina.
     * @param mana       Player's starting mana.
     */
    public Player(String name, char displayChar, int hitPoints, int stamina, int mana) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_FLOOR);
        this.addCapability(Ability.BUYING);
        this.addAttribute(BaseActorAttributes.STAMINA, new BaseActorAttribute(stamina));
        this.addCapability(Ability.UNLOCK_GATE);
    }

    /**
     * Handle the unconscious state of the Player when defeated by other actor.
     *
     * @param actor The perpetrator who caused the Player to become unconscious.
     * @param map   The GameMap where the Player fell unconscious.
     * @return A string describing what happened when the Player is unconscious.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH,ActorAttributeOperations.UPDATE,0);
        String ret = "";
        ret += super.unconscious(actor,map);
        map.removeActor(this);
        ret += "\n" + FancyMessage.YOU_DIED;
        return ret;
    }

    /**
     * Handle the unconscious state of the Player when defeated by natural disaster.
     *
     * @param map The GameMap where the Player fell unconscious.
     * @return A string describing what happened when the Player is unconscious.
     */
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
     * Create an individual intrinsic weapon for the Player.
     * Overrides Actor.getIntrinsicWeapon().
     *
     * @see Actor#getIntrinsicWeapon()
     * @return A new Intrinsic Weapon for the Player.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {

        return new IntrinsicWeapon(15,"bonks",80);
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    Collection of possible Actions for this Actor.
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction().
     * @param map        The map containing the Actor.
     * @param display    The I/O object to which messages may be written.
     * @return The Action to be performed.
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


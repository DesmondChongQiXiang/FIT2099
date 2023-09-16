package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Ability;
import game.utils.FancyMessage;
import game.utils.Status;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Yoong Qian Xin
 *
 */
public class Player extends Actor {
    Display display = new Display();

    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints, int stamina) {
        super(name, displayChar, hitPoints);
        this.addAttribute(BaseActorAttributes.STAMINA, new BaseActorAttribute(stamina));
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_FLOOR);
        this.addCapability(Ability.TRAVEL);
    }

    /**
     * Player can attack enemy with its limbs
     *
     * @return the intrinsic weapon of player.
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(15, "bonks");
    }


    /**
     * Called when the Player is unconscious due to the action of another actor.
     * Overriding unconscious method in Actor abstract class.
     *
     * @param actor the perpetrator
     * @param map where the player fell unconscious
     *
     * @return a string describing what happened when the Player is unconscious
     */
    public String unconscious(Actor actor, GameMap map) {
        display.println(FancyMessage.YOU_DIED);
        return super.unconscious(map);
    }

    /**
     * Called when the Player is unconscious due to natural causes or accident.
     * Overriding unconscious method in Actor abstract class.
     *
     * @param map where the actor fell unconscious
     * @return a string describing what happened when the Player is unconscious
     */
    public String unconscious(GameMap map) {
        display.println(FancyMessage.YOU_DIED);
        return super.unconscious(map);
    }

    /**
     * The player action in each turn.
     *
     * @param actions    collection of possible Actions for this player
     * @param lastAction The Action this player took last turn. Can do interesting things in
     *                   conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     *
     * @return The action to be executed.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        display.println(this.name);
        display.println("HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        display.println("Stamina: " + this.getAttribute(BaseActorAttributes.STAMINA) + "/" + this.getAttributeMaximum(BaseActorAttributes.STAMINA));

        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }


}

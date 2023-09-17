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
import game.actions.Ability;
import game.displays.FancyMessage;
import game.actions.Status;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Ong Chong How
 * @version 1.0
 */
public class Player extends Actor {

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
        this.addCapability(Status.ATTACKED_BY_ENEMY);
        this.addCapability(Ability.ENABLE_ENTER_FLOOR);
    }

    /**
     * Overrides the default behavior for the player character's turn.
     *
     * @param actions    The list of available actions.
     * @param lastAction The last executed action.
     * @param map        The game map on which the player is located.
     * @param display    The display object for rendering the game world.
     * @return The action to be executed during the player's turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        display.println(String.format("%s\nHP: %d/%d\nStamina: %d/%d",name,this.getAttribute(BaseActorAttributes.HEALTH),this.getAttributeMaximum(BaseActorAttributes.HEALTH),this.getAttribute(BaseActorAttributes.STAMINA),this.getAttributeMaximum(BaseActorAttributes.STAMINA)));
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * Handles the unconscious state of the player character by natural .
     *
     * @param map The game map from which the player character is removed.
     * @return A message indicating the outcome of the unconscious state.
     */
    @Override
    public String unconscious(GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE,0);
        new Display().println(new DoNothingAction().execute(this,map));
        map.removeActor(this);
        return FancyMessage.YOU_DIED;
    }

    /**
     * Handles the unconscious state of the player character attacked by other actors.
     *
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE,0);
        new Display().println(new DoNothingAction().execute(this,map));
        map.removeActor(this);
        return FancyMessage.YOU_DIED;
    }

    /**
     * Retrieves the intrinsic weapon of the player character due to natural causes or accident.
     *
     * @return The intrinsic weapon of the player character.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(15,"attacks",80);
    }

}

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
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.capabilities.Ability;
import game.capabilities.Status;
import edu.monash.fit2099.engine.actors.Wallet;
import game.items.Runes;
import game.grounds.AbandonedVillageMap;


/**
 * Class representing the player character in the game.
 *
 * The player character (Player) is controlled by the user and interacts with the game world.
 * It has various capabilities and attributes, such as health, stamina, and the ability to buy items.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @see Actor
 */
public class Player extends Actor {
    private Wallet wallet;
    private AbandonedVillageMap abandonedVillageMap;


    /**
     * Constructor to create a Player character.
     *
     * @param name       Name to call the player in the UI.
     * @param displayChar Character to represent the player in the UI.
     * @param hitPoints  Player's starting number of hit points.
     * @param stamina    Player's starting stamina.
     */
    public Player(String name, char displayChar, int hitPoints, int stamina, AbandonedVillageMap abandonedVillageMap) {
        super(name, displayChar, hitPoints);
        this.wallet = new Wallet();
        this.abandonedVillageMap = abandonedVillageMap;
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_FLOOR);
        this.addCapability(Ability.BUYING);
        this.addCapability(Ability.LISTEN_STORY);
        this.addAttribute(BaseActorAttributes.STAMINA, new BaseActorAttribute(stamina));
    }


    /**
     * Handle the unconscious state of the Player when defeated by another actor.
     *
     * @param actor The perpetrator who caused the Player to become unconscious.
     * @param map   The GameMap where the Player fell unconscious.
     * @return A string describing what happened when the Player is unconscious.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        // Modify the player's health attribute
        int maxHealth = actor.getAttributeMaximum(BaseActorAttributes.HEALTH);
        int maxStamina = actor.getAttributeMaximum(BaseActorAttributes.STAMINA);

        actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE, maxHealth);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.UPDATE, maxStamina);

        String ret = "";
        ret += super.unconscious(actor, map);
        resetWalletAndDropRunes(map);


        GameMap theAbandonedVillage = abandonedVillageMap.getTheAbandonedVillage();
        map.moveActor(this, theAbandonedVillage.at(29, 5));

        ret += "\n";
        return ret;
    }

    /**
     * Handle the unconscious state of the Player when defeated by a natural disaster.
     *
     * @param map The GameMap where the Player fell unconscious.
     * @return A string describing what happened when the Player is unconscious.
     */
    @Override
    public String unconscious(GameMap map) {
        // Modify the player's health attribute
        int maxHealth = this.getAttributeMaximum(BaseActorAttributes.HEALTH);
        int maxStamina = this.getAttributeMaximum(BaseActorAttributes.STAMINA);

        // Reset health and stamina to their maximum values
        this.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE, maxHealth);
        this.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.UPDATE, maxStamina);
        String ret = "";
        resetWalletAndDropRunes(map);

        GameMap theAbandonedVillage = abandonedVillageMap.getTheAbandonedVillage();
        map.moveActor(this, theAbandonedVillage.at(29, 5));

        ret += "\n" ;
        return ret;
    }
    private void resetWalletAndDropRunes(GameMap map) {
        int lastBalance = wallet.getBalance();  // Get current wallet balance
        wallet.deductBalance(lastBalance);  // Reset wallet to 0

        Runes droppedRunes = new Runes(lastBalance);  // Create Runes with last balance
        Location lastLocation = map.locationOf(this);
        lastLocation.addItem(droppedRunes);  // Add Runes to last known location
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
        return new IntrinsicWeapon(15, "bonks", 80);
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
        this.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, (int) (this.getAttributeMaximum(BaseActorAttributes.STAMINA) * 0.01f));

        if (lastAction.getNextAction() != null) {
            return lastAction.getNextAction();
        }

        display.println(this.name);
        display.println("HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        display.println("Stamina: " + this.getAttribute(BaseActorAttributes.STAMINA) + "/" + this.getAttributeMaximum(BaseActorAttributes.STAMINA));
        display.println("Runes: " + wallet.getBalance());
        // Return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }


}



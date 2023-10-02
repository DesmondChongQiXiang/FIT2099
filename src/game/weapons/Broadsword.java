package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ActivateSkillAction;
import game.actions.ActiveSkill;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.capabilities.Ability;
import game.capabilities.Status;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The Broadsword class represents a specialized weapon in the game.
 * It extends the WeaponItem class and implements the ActiveSkill, Sellable, and Purchasable interfaces.
 * This weapon has unique capabilities and actions, including a special skill.
 */

public class Broadsword extends WeaponItem implements ActiveSkill, Sellable, Purchasable {

    /**
     * A counter to count the number of turn after activate the weapon skill
     */
    private int counter;

    /**
     * A boolean that represent the status of skill activation
     */
    private boolean isActivated;

    /**
     * Constructor.
     */
    public Broadsword(){
        super("broadsword", '1', 110, "slashes",80 );
        counter = 0;
        isActivated = false;
    }

    /**
     * List of allowable actions that the item can perform to the current actor.
     * Broadsword will decrease the stamina of the owner.
     *
     * @param owner the actor that owns the item
     * @return a list of actions contain ActivateSkillAction
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ActivateSkillAction(this));
        return actions;
    }

    /**
     * List of allowable actions that the item allows its owner do to other actor.
     * broadsword can return an attacking action to the other actor.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of actions that contains an AttackAction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.ENEMY)) {
            actions.add(new AttackAction(otherActor, location.toString(), this));
        }
        if (otherActor.hasCapability(Ability.BUYING)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Decrease the stamina of the owner and update the status after the weapon is activated.
     *
     * @param owner the owner that activate the weapon
     * @return a String that describe the message of activate the weapon skill
     */
    @Override
    public String activateSkill(Actor owner, Actor target, GameMap map) {
        try{
            staminaConsumedByActivateSkill(owner);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return skillAction(owner,target,map);
    }

    /**
     * Consumes stamina when the special skill is activated.
     *
     * @param owner The actor activating the skill.
     */
    @Override
    public void staminaConsumedByActivateSkill(Actor owner) {
        int staminaCost = (int)(owner.getAttributeMaximum(BaseActorAttributes.STAMINA) * 0.20f);

        // Check if the actor has enough stamina
        if (owner.getAttribute(BaseActorAttributes.STAMINA) <= staminaCost) {
            throw new IllegalStateException(owner + " doesn't have enough stamina to use the special skill!");
        }
        else {
            owner.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        }
    }

    /**
     * Executes the skill action, which includes increasing damage multiplier and hit rate.
     *
     * @param owner The actor activating the skill.
     * @param target The target actor.
     * @param map The game map.
     * @return A string describing the outcome.
     */
    @Override
    public String skillAction(Actor owner, Actor target, GameMap map) {
        this.increaseDamageMultiplier(0.10f);
        this.updateHitRate(90);
        this.isActivated = true;

        return String.format("%s takes a deep breath and focuses all their might!", owner);
    }

    /**
     * Inform a broadsword of the passage of time.
     * Revert the status of the activated broadsword after 5 turns.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (isActivated) {
            counter += 1;
            if (counter > 5){
                revertBack();
            }
        }
    }

    /**
     * Update and revert the status of the broadsword.
     * Revert the status same as the status before activated.
     */
    public void revertBack(){
        this.updateDamageMultiplier(1.0f);
        counter = 0;
        isActivated = false;
    }

    /**
     * Maintain the initial status of the broadsword when the broadsword rests upon the ground.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        revertBack();
        this.updateHitRate(80);
    }


    /**
     * Handles the purchase of the item.
     *
     * @param actor The actor attempting to purchase the item.
     * @return The purchase price of the item.
     */
    @Override
    public int purchasedBy(Actor actor, int purchasePrice) {
        if (actor.getBalance() - purchasePrice < 0){
            throw new IllegalStateException("Player's balance is insufficient");
        }
        else{
            if (Math.random() <= 0.95){
                actor.addItemToInventory(this);
            }
            actor.deductBalance(purchasePrice);
        }
        return purchasePrice;
    }

    /**
     * Handles the selling of the item.
     *
     * @param actor The actor selling the item.
     * @return The selling price of the item.
     */
    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 100;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }
}

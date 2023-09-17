package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ActivateSkillAction;
import game.actions.AttackAction;

/**
 * A class representing a broadsword weapon item in the game.
 *
 * The broadsword has the ability to activate a focus skill that increases its damage and hit rate for a limited time.
 *
 * @author Ong Chong How
 *
 * @see WeaponItem
 * @see WeaponSkill
 *
 * @version 1.0
 */
public class BroadSword extends WeaponItem implements WeaponSkill {

    private boolean isActivated;
    private int counter;

    /**
     * Constructor to create a BroadSword object.
     *
     * @param name        The name of the item.
     * @param displayChar The character to use for display when the item is on the ground.
     * @param damage      The amount of damage this weapon does.
     * @param verb        The verb to use for this weapon, e.g., "hits", "zaps".
     * @param hitRate     The probability/chance to hit the target.
     */
    public BroadSword(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
        this.isActivated=false;
        this.counter=0;
    }

    /**
     * Activates the focus skill of the broadsword, increasing its damage multiplier and hit rate,
     * and reducing the actor's stamina. The skill lasts for a limited time.
     *
     * @param actor The actor using the focus skill.
     * @return A message indicating the activation of the focus skill.
     */
    @Override
    public String activateFocusSkill(Actor actor) {
        increaseDamageMultiplier(.1f);
        updateHitRate(90);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, (int)(actor.getAttributeMaximum(BaseActorAttributes.STAMINA)*.2f));
        isActivated=true;
        counter=0;
        return String.format("%s takes a deep breath and focuses all their night", actor);
    }

    /**
     * Reverts the status of the broadsword, resetting the damage multiplier and hit rate.
     */
    public void revertStatus() {
        updateDamageMultiplier(1.0f);
        isActivated=false;
    }

    /**
     * Generates a list of allowable actions when an actor interacts with this item.
     *
     * @param owner The actor interacting with the item.
     * @return An ActionList containing the action to activate the focus skill.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ActivateSkillAction(this));
        return actionList;
    }

    /**
     * Generates a list of allowable actions when this item is used to attack another actor.
     *
     * @param otherActor The actor being attacked.
     * @param location   The location of the other actor.
     * @return An ActionList containing the action to attack the other actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        actionList.add(new AttackAction(otherActor, location.map().locationOf(otherActor).toString(), this));
        return actionList;
    }

    /**
     * Handles the passage of time for the broadsword, including stamina recovery and focus skill duration.
     *
     * @param currentLocation The location where the broadsword is located.
     * @param actor           The actor carrying or using the broadsword.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, (int)(actor.getAttributeMaximum(BaseActorAttributes.STAMINA)*.01f));
        counter = isActivated ? counter+1 : 0;
        if(counter>5){
            revertStatus();
        }
    }

    /**
     * Handles the passage of time for the broadsword, resetting its status.
     *
     * @param currentLocation The location where the broadsword is located.
     */
    @Override
    public void tick(Location currentLocation) {
        updateDamageMultiplier(1.0f);
        updateHitRate(80);
        isActivated=false;
    }
}
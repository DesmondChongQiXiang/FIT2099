package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;

/**
 * A class that represents a stack of runes as an item in the game.
 *
 * Runes can be consumed by an actor to increase their balance (currency) by a specified amount.
 * They are consumable items and can only be consumed once.
 *
 * @author MA_AppliedSession1_Group7
 */
public class Runes extends Item implements Consumable {

    private int amount;
    private boolean isPlayerDead;

    /**
     * Constructor to create a stack of runes with a specified amount.
     *
     * @param amount The amount of currency represented by this stack of runes.
     */
    public Runes(int amount) {
        super("Runes", '$', true);
        this.amount = amount;
        this.isPlayerDead = false;
    }

    /**
     * Increases the actor's balance by the specified amount when the runes are consumed.
     * The runes are removed from the actor's inventory after consumption.
     *
     * @param actor The actor who consumes the runes.
     * @return A description of the consumption action and its effects.
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.addBalance(amount);
        actor.removeItemFromInventory(this);
        return String.format("%s consumes Runes",actor) ;
    }

    /**
     * Returns a list of allowable actions that can be performed on these runes by the owner actor.
     *
     * @param owner The actor that owns the runes.
     * @return A list of allowable actions for the owner actor.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        if (isPlayerDead){
            currentLocation.removeItem(this);
            playerDead();
            System.out.println("aaaaa");
        }
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        //check if the runes is in player inventory, set the boolean back when player respawn
        if (isPlayerDead) {
            playerDead();
        }
        super.tick(currentLocation, actor);
    }


    public void playerDead(){
        isPlayerDead = !isPlayerDead;
    }
}

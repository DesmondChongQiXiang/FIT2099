package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.GreatSlamAction;
import game.capabilities.Ability;
import game.items.Sellable;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import edu.monash.fit2099.engine.positions.Exit;

/**
 * The GiantHammer class represents a specialized weapon item that has unique actions and abilities.
 * It extends the WeaponItem class and implements the Sellable interface.
 *
 * @author Maliha Tariq
 */
public class GiantHammer extends WeaponItem implements Sellable {

    /**
     * The game map where the GiantHammer exists.
     */
    private GameMap gameMap;

    /**
     * Constructor to initialize the GiantHammer.
     *
     * @param gameMap The game map where the GiantHammer exists.
     */
    public GiantHammer(GameMap gameMap) {
        super("Giant Hammer", 'P', 160, "slams", 90);
        this.gameMap = gameMap;
        addCapability(Ability.HAS_SPECIAL_SKILL);
        addCapability(Ability.SELLABLE);
    }

    /**
     * Returns the allowable actions that can be performed with this weapon.
     *
     * @param otherActor The actor performing the action.
     * @param location The location where the action takes place.
     * @return A list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        actions.add(new GreatSlamAction(this, otherActor, gameMap));
        return actions;
    }

    /**
     * Defines the selling process of the GiantHammer.
     *
     * @param actor The actor selling the item.
     * @return The selling price of the item.
     */
    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 250;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

    /**
     * Performs the Great Slam action using the GiantHammer.
     *
     * @param actor The actor performing the action.
     * @param targetActor The target actor on whom the action will be performed.
     * @param gameMap The game map where the action takes place.
     */
    public void performGreatSlam(Actor actor, Actor targetActor, GameMap gameMap) {
        int damageToTarget = this.damage();
        targetActor.hurt(damageToTarget);


        int damageToSurroundings = (int) (0.5 * this.damage());
        Location targetLocation = gameMap.locationOf(targetActor);

        // Deal damage to all actors in the surrounding locations of the target actor
        for (Exit exit : targetLocation.getExits()) {
            Location adjacentLocation = exit.getDestination();
            if (adjacentLocation.containsAnActor()) {
                Actor actorInLocation = adjacentLocation.getActor();
                actorInLocation.hurt(damageToSurroundings);
            }
        }

        // Consume 5% of the actor’s maximum stamina
        if (actor.hasCapability(Ability.PLAYER)) {
            Player playerActor = (Player) actor;
            playerActor.consumeStamina((int) (0.05 * playerActor.getMaxStamina()));
        }

    }
}

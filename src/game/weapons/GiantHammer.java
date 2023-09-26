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
 * A class that represents the Giant Hammer weapon
 */
public class GiantHammer extends WeaponItem implements Sellable {
    private GameMap gameMap; // Instance variable to store GameMap

    // Adjusted constructor to accept GameMap
    public GiantHammer(GameMap gameMap) {
        super("Giant Hammer", 'P', 160, "slams", 90);
        this.gameMap = gameMap; // Store GameMap
        addCapability(Ability.HAS_SPECIAL_SKILL);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        actions.add(new GreatSlamAction(this, otherActor, gameMap)); // Use GameMap instance variable
        return actions;
    }



    @Override
    public int soldBy(Actor actor) {
        int sellingPrice = 250;
        actor.addBalance(sellingPrice);
        actor.removeItemFromInventory(this);
        return sellingPrice;
    }

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

        // Consume 5% of the actor’s maximum stamina if actor is a player
        if (actor.hasCapability(Ability.PLAYER)) { // Assuming Ability.PLAYER is a unique capability of Player
            Player playerActor = (Player) actor;
            playerActor.consumeStamina((int) (0.05 * playerActor.getMaxStamina()));
        }

    }
}

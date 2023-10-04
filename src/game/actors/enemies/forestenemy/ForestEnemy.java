package game.actors.enemies.forestenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.FollowBehaviour;
import game.capabilities.Status;

public abstract class ForestEnemy extends Enemy {
    /**
     * Constructor.
     */
    public ForestEnemy(String name, char displayChar, int hitPoints){
        super(name,displayChar,hitPoints);
    }

    /**
     * Enemy can follow actor that has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of actions that is allowed to be executed/performed on the current actor.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(998, new FollowBehaviour(otherActor));
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }

    public abstract void sunnyMode();

    public abstract void rainyMode();
}

package game.actors.enemies.villageenemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;
import game.capabilities.Status;

public abstract class VillageEnemy extends Enemy {
    /**
     * Constructor.
     */
    public VillageEnemy(String name, char displayChar, int hitPoints,int runesNumDropped){
        super(name,displayChar,hitPoints,runesNumDropped);
    }

    /**
     * Enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of actions that is allowed to be executed/performed on the current actor.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}

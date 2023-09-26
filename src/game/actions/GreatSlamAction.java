package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.*;

public class GreatSlamAction extends Action {
    private final GiantHammer giantHammer;
    private final Actor targetActor;
    private final GameMap gameMap;

    public GreatSlamAction(GiantHammer giantHammer, Actor targetActor, GameMap gameMap) {
        this.giantHammer = giantHammer;
        this.targetActor = targetActor;
        this.gameMap = gameMap;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        giantHammer.performGreatSlam(actor, targetActor, gameMap);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs Great Slam on " + targetActor;
    }
}

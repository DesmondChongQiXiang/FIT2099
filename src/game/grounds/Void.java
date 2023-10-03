package game.grounds;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Ability;

public class Void extends Ground{
    /**
     * Constructor.
     */
    public Void() {
        super('+');
    }

    /**
     * Void can kill an actor when the actor step on it
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && !location.getActor().hasCapability(Ability.ENTER_VOID)){
            new Display().println(location.getActor().unconscious(location.map()));
        }
    }


}
package game.grounds;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;


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
        if (location.containsAnActor()){
            new Display().println(location.getActor().unconscious(location.map()));
        }
    }
}

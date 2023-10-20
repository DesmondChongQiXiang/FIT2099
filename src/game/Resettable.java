package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface Resettable{
    void reset();
    void resetAction(Location location);
}

package game.gamemap;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import java.util.List;

/**
 * A class that represent The Abandoned Village game map.
 */
public class TheAbandonedVillage extends GameMap {
    /**
     * Constructor that creates a map from a sequence of ASCII strings.
     *
     * @param groundFactory Factory to create Ground objects
     * @param lines         List of Strings representing rows of the map
     */
    public TheAbandonedVillage(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    /**
     * Returns a description of this game map to display in the menu.
     *
     * @return a String, "The Abandoned Village"
     */
    @Override
    public String toString() {
        return "The Abandoned Village";
    }
}

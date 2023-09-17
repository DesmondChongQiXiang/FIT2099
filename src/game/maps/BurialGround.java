package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.List;

/**
 * The BurialGround class represents a specific game map where the terrain consists of various grounds
 * and actors can interact within the map. It extends the GameMap class, providing functionality
 * for creating and managing this specific game map.
 *
 * This class is used to represent a burial ground within the game.
 * The burial ground is a specialized map where players and enemies may interact.
 *
 * @author Ong Chong How
 *
 * @see edu.monash.fit2099.engine.positions.GameMap
 * @see edu.monash.fit2099.engine.positions.GroundFactory
 *
 * @version 1.0
 */
public class BurialGround extends GameMap {

    /**
     * Constructor for creating a BurialGround instance.
     *
     * @param groundFactory The factory responsible for generating the terrain elements of the map.
     * @param lines         A list of strings representing the map layout.
     */
    public BurialGround(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    /**
     * Returns a string representation of this BurialGround instance, which is the name of the map.
     *
     * @return The name of the map, in this case, "The Burial Ground".
     */
    public String toString(){
        return "The Burial Ground";
    }
}

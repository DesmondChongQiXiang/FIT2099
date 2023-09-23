package game.gamemap;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import java.util.List;

/**
 * A class that represent The Ancient Wood game map.
 */
public class TheAncientWood extends GameMap {
  /**
   * Constructor that creates a map from a sequence of ASCII strings.
   *
   * @param groundFactory Factory to create Ground objects
   * @param lines         List of Strings representing rows of the map
   */
  public TheAncientWood(GroundFactory groundFactory, List<String> lines) {
    super(groundFactory, lines);
  }

  /**
   * Returns a description of this game map to display in the menu.
   *
   * @return a String, "The Ancient Wood"
   */
  @Override
  public String toString() {
    return "The Ancient Wood";
  }
}

package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 *  A class that represents bottomless pit.
 *  Any entity, including the player, will be killed if they step on it.
 *
 *  @author Yoong Qian Xin
 */
public class Void extends Ground {
  Display display = new Display();

  /**
   * Constructor.
   */
  public Void() {
    super('+');
  }

  /**
   *  If the actor in the location is killed, called the overridden unconscious method in Player class.
   *
   *  @param location the location of the Ground
   */
  @Override
  public void tick(Location location) {
    String ret = "";
    if (location.containsAnActor()) {
      Actor actor = location.getActor();
      actor.unconscious(location.map());  // overridden unconscious method in player class
      ret += (actor + " has stepped into the bottomless pit.\n");
      ret += "Game Over";
      display.println(ret);
      System.exit(0);
    }
  }


}

package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.World;


/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: MA_AppliedSession1_Group7
 *
 */
public class Application {

    public static void main(String[] args) {

        Designborne designborne = new Designborne(new World(new Display()));
        designborne.run();

    }
}
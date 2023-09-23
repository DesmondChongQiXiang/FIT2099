package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actions.TravelAction;
import game.actors.Player;
import game.displays.FancyMessage;
import game.gamemap.TheBurialGround;
import game.gamemap.TheAbandonedVillage;
import game.ground.*;
import game.ground.Void;
import game.weapons.Broadsword;
import game.spawner.HollowSoldierSpawner;
import game.spawner.Spawner;
import game.spawner.WanderingUndeadSpawner;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory abandonedVillageFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(),new Void());

        List<String> abandonedVillage = Arrays.asList(
                "...........................................................",
                "...#######.................................................",
                "...#__.......................................++++..........",
                "...#..___#...................................+++++++.......",
                "...###.###................#######..............+++.........",
                "..........................#_____#................+++.......",
                "........~~................#_____#.................+........",
                ".........~~~..............###_###................++........",
                "...~~~~~~~~....+++.........................................",
                "....~~~~~........+++++++..................###..##...++++...",
                "~~~~~~~..............+++..................#___..#...++.....",
                "~~~~~~.................++.................#..___#....+++...",
                "~~~~~~~~~.................................#######.......++.");

        GameMap theAbandonedVillage = new TheAbandonedVillage(abandonedVillageFactory, abandonedVillage);
        world.addGameMap(theAbandonedVillage);

        Spawner wanderingUndeadSpawner = new WanderingUndeadSpawner();
        theAbandonedVillage.at(10,8).setGround(new Graveyard(wanderingUndeadSpawner));

        Item broadsword = new Broadsword();
        theAbandonedVillage.at(27, 6).addItem(broadsword);


        FancyGroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(),new Void());
        List<String> burialGroundMap = Arrays.asList("...........+++++++........~~~~~~++....~~",
                "...........++++++.........~~~~~~+.....~~",
                "............++++...........~~~~~......++",
                "............+.+.............~~~.......++",
                "..........++~~~.......................++",
                ".........+++~~~....#######...........+++",
                ".........++++~.....#_____#.........+++++",
                "..........+++......#_____#........++++++",
                "..........+++......###_###.......~~+++++",
                "..........~~.....................~~...++",
                "..........~~~..................++.......",
                "...........~~....~~~~~.........++.......",
                "......~~....++..~~~~~~~~~~~......~......",
                "....+~~~~..++++++++~~~~~~~~~....~~~.....",
                "....+~~~~..++++++++~~~..~~~~~..~~~~~....");

        GameMap burialGround = new TheBurialGround(burialGroundFactory,burialGroundMap);
        world.addGameMap(burialGround);

        Spawner hollowSoldierSpawner = new HollowSoldierSpawner();
        burialGround.at(21,11).setGround(new Graveyard(hollowSoldierSpawner));

        Gate abandonedVillageGate = new Gate();
        abandonedVillageGate.addTravelAction(new TravelAction(burialGround.at(21, 1)));
        theAbandonedVillage.at(30, 0).setGround(abandonedVillageGate);

        Gate burialGroundGate = new Gate();
        burialGroundGate.addTravelAction(new TravelAction(theAbandonedVillage.at(30, 1)));
        burialGround.at(21,0).setGround(burialGroundGate);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("The Abstracted One", '@', 150,200);
        world.addPlayer(player, theAbandonedVillage.at(29, 5));

        world.run();
    }
}

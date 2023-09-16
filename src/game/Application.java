package game;

import game.actors.enemies.HollowSoldier;
import game.actors.Player;
import game.actors.enemies.WanderingUndead;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Graveyard;
import game.grounds.Gate;
import game.grounds.Puddle;
import game.grounds.Void;
import game.grounds.Wall;
import game.utils.FancyMessage;
import game.weapons.Broadsword;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import java.util.Arrays;
import java.util.List;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Yoong Qian Xin
 *
 */
public class Application {

    /**
     * The main application running the game.
     *
     * @param args String class that stores java command line arguments
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Void());

        List<String> abandonedVillageMap = Arrays.asList(
                "...........................................................",
                "...#######.................................................",
                "...#__.......................................++++..........",
                "...#..___#...................................+++++++.......",
                "...###.###................#######..............+++.........",
                "..........................#_____#................+++.......",
                "........~~................#_____#.................+........",
                ".........~~~..............###_###................++........",
                "...~~~~~~~~....+++.........................................",
                "....~~~~~........++++++...................###..##...++++...",
                "~~~~~~~.............+++...................#___..#...++.....",
                "~~~~~~.................++.................#..___#....+++...",
                "~~~~~~~~~.................................#######........++");

        GameMap abandonedVillage = new GameMap(groundFactory, abandonedVillageMap);
        world.addGameMap(abandonedVillage);


        List<String> burialGroundMap = Arrays.asList(
            "...........+++++++........~~~~~~++....~~",
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

        GameMap burialGround = new GameMap(groundFactory, burialGroundMap);
        world.addGameMap(burialGround);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        abandonedVillage.at(29, 11).addActor(new WanderingUndead());

        Player player = new Player("The Abstracted One", '@', 150, 200);
        world.addPlayer(player, abandonedVillage.at(29, 5));

        Broadsword broadsword = new Broadsword("Broadsword", '1', 110, "slashes", 80);
        abandonedVillage.at(28,6).addItem(broadsword);

        burialGround.at(29,7).addActor(new HollowSoldier());

        Graveyard graveyard1 = new Graveyard(new WanderingUndead(), 0.25);
        Graveyard graveyard2 = new Graveyard(new HollowSoldier(), 0.10);

        abandonedVillage.at(30,11).setGround(graveyard1);
        burialGround.at(30, 14).setGround(graveyard2);

        abandonedVillage.at(25,8).setGround(new Gate(burialGround.at(20,10),  "to Burial Ground"));
        burialGround.at(20,10).setGround(new Gate(abandonedVillage.at(25,8), "to Abandoned Village"));


        world.run();
    }


}

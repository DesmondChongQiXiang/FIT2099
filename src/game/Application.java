package game;

import A2.RedWolf;
import game.actors.enemies.ForestKeeper;
import game.actors.enemies.HollowSoldier;
import game.actors.enemies.WanderingUndead;
import game.gamemap.TheAncientWood;
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
import game.grounds.*;
import game.grounds.Void;
import game.weapons.Broadsword;

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

        // The Abandoned Village
        FancyGroundFactory abandonedVillageFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(),new Void());

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
                "....~~~~~........+++++++..................###..##...++++...",
                "~~~~~~~..............+++..................#___..#...++.....",
                "~~~~~~.................++.................#..___#....+++...",
                "~~~~~~~~~.................................#######.......++.");

        GameMap theAbandonedVillage = new TheAbandonedVillage(abandonedVillageFactory, abandonedVillageMap);
        world.addGameMap(theAbandonedVillage);

        theAbandonedVillage.at(10,8).setGround(new Graveyard(new WanderingUndead(), 0.25));

        Item broadsword = new Broadsword();
        theAbandonedVillage.at(27, 6).addItem(broadsword);

        // The Burial Ground
        FancyGroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(),
            new Wall(), new Floor(), new Puddle(),new Void());

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

        GameMap theBurialGround = new TheBurialGround(burialGroundFactory, burialGroundMap);
        world.addGameMap(theBurialGround);

        theBurialGround.at(21,11).setGround(new Graveyard(new HollowSoldier(), 0.10));

        Gate abandonedVillageGate = new Gate();
        abandonedVillageGate.addTravelAction(new TravelAction(theBurialGround.at(21, 1)));
        theAbandonedVillage.at(30, 0).setGround(abandonedVillageGate);

        Gate burialGroundGate = new Gate();
        burialGroundGate.addTravelAction(new TravelAction(theBurialGround.at(30, 1)));
        theBurialGround.at(21,0).setGround(burialGroundGate);

        // The Ancient Wood
        FancyGroundFactory ancientWoodFactory = new FancyGroundFactory(new Dirt(),
            new Wall(), new Floor(), new Puddle(),new Void());

        List<String> ancientWoodMap = Arrays.asList(
            "....+++..............................+++++++++....~~~....~~~",
            "+...+++..............................++++++++.....~~~.....~~",
            "++...............#######..............++++.........~~.......",
            "++...............#_____#...........................~~~......",
            "+................#_____#............................~~......",
            ".................###_###............~...............~~.....~",
            "...............................~.+++~~..............~~....~~",
            ".....................~........~~+++++...............~~~...~~",
            "....................~~~.........++++............~~~~~~~...~~",
            "....................~~~~.~~~~..........~........~~~~~~.....~",
            "++++...............~~~~~~~~~~~........~~~.......~~~~~~......",
            "+++++..............~~~~~~~~~~~........~~~........~~~~~......");

        GameMap theAncientWood = new TheAncientWood(ancientWoodFactory, ancientWoodMap);
        world.addGameMap(theAncientWood);

        Gate ancientWoodGate = new Gate();
        ancientWoodGate.addTravelAction(new TravelAction(theBurialGround.at(25, 1)));
        theAncientWood.at(23,0).setGround(ancientWoodGate);

        theAncientWood.at(15, 10).setGround(new Hut(new ForestKeeper(), 0.15));
        theAncientWood.at(10, 8).setGround(new Bushes(new RedWolf(), 0.30));


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

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
import game.actors.Traveller;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.environments.Bushes;
import game.grounds.environments.Hut;
import game.grounds.environments.Graveyard;
import game.items.BloodBerry;
import game.spawners.*;
import game.weapons.Broadsword;
import game.weapons.GiantHammer;
import game.items.Key;

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

        GameMap theAbandonedVillage = new GameMap(abandonedVillageFactory, abandonedVillage);
        world.addGameMap(theAbandonedVillage);

        Spawner wanderingUndeadSpawner = new WanderingUndeadSpawner();
        theAbandonedVillage.at(10,8).setGround(new Graveyard(wanderingUndeadSpawner));

        Item broadsword = new Broadsword();
        theAbandonedVillage.at(27, 6).addItem(broadsword);


        FancyGroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(),new Void());
        List<String> burialGroundMap = Arrays.asList
                ("...........+++++++........~~~~~~++....~~",
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

        GameMap burialGround = new GameMap(burialGroundFactory,burialGroundMap);
        world.addGameMap(burialGround);

        Spawner hollowSoldierSpawner = new HollowSoldierSpawner();
        burialGround.at(21,11).setGround(new Graveyard(hollowSoldierSpawner));

        Gate abandonedVillageGate = new Gate();
        abandonedVillageGate.addTravelAction(new TravelAction(burialGround.at(22, 7),"The Burial Ground"));
        theAbandonedVillage.at(30, 5).setGround(abandonedVillageGate);

        Gate burialGroundGate = new Gate();
        burialGroundGate.addTravelAction(new TravelAction(theAbandonedVillage.at(31, 5),"The Abandoned Village"));
        burialGround.at(23,7).setGround(burialGroundGate);


        FancyGroundFactory ancientWoodsFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(),new Void());

        List<String> ancientWoodsMap = Arrays.asList
                ("....+++..............................+++++++++....~~~....~~~",
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


        GameMap ancientWoods = new GameMap(ancientWoodsFactory,ancientWoodsMap);
        world.addGameMap(ancientWoods);

        ancientWoods.at(29,0).setGround(new Hut());
        ancientWoods.at(15,11).setGround(new Bushes());

        Gate burialGroundGate2 = new Gate();
        burialGroundGate2.addTravelAction(new TravelAction(ancientWoods.at(21, 4),"The Ancient Woods"));
        burialGround.at(30, 14).setGround(burialGroundGate2);

        Gate ancientWoodsGate = new Gate();
        ancientWoodsGate.addTravelAction(new TravelAction(burialGround.at(15, 14),"The Burial Ground"));
        ancientWoods.at(10,11).setGround(ancientWoodsGate);

        ancientWoods.at(10,7).addItem(new BloodBerry());
        ancientWoods.at(20,1).addItem(new BloodBerry());
        ancientWoods.at(15,6).addItem(new BloodBerry());
        ancientWoods.at(3,9).addItem(new BloodBerry());


        FancyGroundFactory abxervyerFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(), new Void());
        List<String> abxervyerMap = Arrays.asList(
                "~~~~.......+++......~+++++..............",
                "~~~~.......+++.......+++++..............",
                "~~~++......+++........++++..............",
                "~~~++......++...........+..............+",
                "~~~~~~...........+.......~~~++........++",
                "~~~~~~..........++++....~~~~++++......++",
                "~~~~~~...........+++++++~~~~.++++.....++",
                "~~~~~..............++++++~~...+++.....++",
                "......................+++......++.....++",
                ".......................+~~............++",
                ".......................~~~~...........++",
                "........................~~++...........+",
                ".....++++...............+++++...........",
                ".....++++~..............+++++...........",
                "......+++~~.............++++...........~",
                ".......++..++++.......................~~",
                "...........+++++......................~~",
                "...........++++++.....................~~",
                "..........~~+++++......................~",
                ".........~~~~++++..................~~..~");

        GameMap abxervyer = new GameMap(abxervyerFactory, abxervyerMap);
        world.addGameMap(abxervyer);

//        Gate lockedGate = new Gate();
//        theAbandonedVillage.at(15, 11).setGround(lockedGate);
//
//        Key oldKey = new Key();
//        theAbandonedVillage.at(7, 11).addItem(oldKey);

        abxervyer.at(10, 19).setGround(new Hut());
        abxervyer.at(32, 0).setGround(new Hut());
        abxervyer.at(11, 13).setGround(new Bushes());
        abxervyer.at(36, 18).setGround(new Bushes());



        GiantHammer giantHammer = new GiantHammer();
        abxervyer.at(6, 8).addItem(giantHammer);
        Gate abxervyerGate = new Gate();

        abxervyerGate.addTravelAction(new TravelAction(theAbandonedVillage.at(31, 5), "The Abandoned Village"));
        abxervyer.at(15, 13).setGround(abxervyerGate);



        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("The Abstracted One", '@', 150, 200, 0);
        world.addPlayer(player, abxervyer.at(6, 7));

        Traveller traveller = new Traveller();
        ancientWoods.at(20,3).addActor(traveller);

        world.run();
    }
}


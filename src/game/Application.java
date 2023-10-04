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
import game.actors.enemies.forestenemy.ForestWatcher;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.environments.forestenemyspawnableground.Bushes;
import game.grounds.environments.forestenemyspawnableground.ForestEnemySpawnableGround;
import game.grounds.environments.forestenemyspawnableground.Hut;
import game.grounds.environments.villageenemyspawnableground.AbandonedVillageGraveyard;
import game.grounds.environments.villageenemyspawnableground.BurialGroundGraveyard;
import game.items.BloodBerry;
import game.spawners.forestenemyspawner.ForestKeeperSpawner;
import game.spawners.forestenemyspawner.RedWolfSpawner;
import game.spawners.villageenemyspawner.HollowSoldierSpawner;
import game.spawners.villageenemyspawner.WanderingUndeadSpawner;
import game.weapons.Broadsword;
import game.weapons.GiantHammer;

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

        theAbandonedVillage.at(10,8).setGround(new AbandonedVillageGraveyard(new WanderingUndeadSpawner()));

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

        burialGround.at(21,11).setGround(new BurialGroundGraveyard(new HollowSoldierSpawner()));

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

        ancientWoods.at(29,0).setGround(new Hut(new ForestKeeperSpawner()));
        ancientWoods.at(15,11).setGround(new Bushes(new RedWolfSpawner()));

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

        ForestEnemySpawnableGround hut1 = new Hut(new ForestKeeperSpawner();
        ForestEnemySpawnableGround hut2 = new Hut(new ForestKeeperSpawner();
        ForestEnemySpawnableGround bush1 = new Bushes(new RedWolfSpawner());
        ForestEnemySpawnableGround bush2 = new Bushes(new RedWolfSpawner());
        abxervyer.at(10, 19).setGround(hut1);
        abxervyer.at(32, 0).setGround(hut2);
        abxervyer.at(11, 13).setGround(bush1);
        abxervyer.at(36, 18).setGround(bush2);

        Gate ancientWoodsGate2 = new Gate();
        ancientWoodsGate2.addTravelAction(new TravelAction(abxervyer.at(39, 13), "Abxervyer, The Forest Watcher"));
        ancientWoods.at(0, 6).setGround(ancientWoodsGate2);


        GiantHammer giantHammer = new GiantHammer();
        abxervyer.at(39, 12).addItem(giantHammer);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("The Abstracted One", '@', 150, 200, 0);
        world.addPlayer(player, abxervyer.at(39, 13));

        Traveller traveller = new Traveller();
        ancientWoods.at(20,3).addActor(traveller);

        ForestWatcher forestWatcher = new ForestWatcher();
        abxervyer.at((abxervyer.getXRange().max())/2,(abxervyer.getYRange().max())/2).addActor(forestWatcher);
        world.run();
    }
}


package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actions.TravelAction;
import game.actors.Blacksmith;
import game.actors.Player;
import game.actors.Traveller;
import game.actors.enemies.ForestWatcher;
import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.forestenemy.ForestKeeper;
import game.actors.enemies.forestenemy.RedWolf;
import game.actors.enemies.sanctuaryenemy.EldentreeGuardian;
import game.actors.enemies.sanctuaryenemy.LivingBranch;
import game.actors.enemies.sanctuaryenemy.SanctuaryEnemy;
import game.actors.enemies.villageenemy.HollowSoldier;
import game.actors.enemies.villageenemy.WanderingUndead;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.environments.forest.ForestBush;
import game.grounds.environments.forest.ForestEnemySpawnableGround;
import game.grounds.environments.forest.ForestHut;
import game.grounds.environments.sanctuary.SanctuaryBush;
import game.grounds.environments.sanctuary.SanctuaryEnemySpawnableGround;
import game.grounds.environments.sanctuary.SanctuaryHut;
import game.grounds.environments.village.WanderingUndeadGraveyard;
import game.grounds.environments.village.HollowSoldierGraveyard;
import game.items.BloodBerry;
import game.weapons.Broadsword;
import game.weapons.GiantHammer;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

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

//        FancyGroundFactory abandonedVillageFactory = new FancyGroundFactory(new Dirt(),
//                new Wall(), new Floor(), new Puddle(),new Void());

//        List<String> abandonedVillage = Arrays.asList(
//                "...........................................................",
//                "...#######.................................................",
//                "...#__.......................................++++..........",
//                "...#..___#...................................+++++++.......",
//                "...###.###................#######..............+++.........",
//                "..........................#_____#................+++.......",
//                "........~~................#_____#.................+........",
//                ".........~~~..............###_###................++........",
//                "...~~~~~~~~....+++.........................................",
//                "....~~~~~........+++++++..................###..##...++++...",
//                "~~~~~~~..............+++..................#___..#...++.....",
//                "~~~~~~.................++.................#..___#....+++...",
//                "~~~~~~~~~.................................#######.......++.");
//
//        GameMap theAbandonedVillage = new GameMap(abandonedVillageFactory, abandonedVillage);
//        world.addGameMap(theAbandonedVillage);

//        theAbandonedVillage.at(10,8).setGround(new WanderingUndeadGraveyard<WanderingUndead>(WanderingUndead.SPAWNER));

        Item broadsword = new Broadsword();
        theAbandonedVillage.at(27, 6).addItem(broadsword);


//        FancyGroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(),new Void());
//        List<String> burialGroundMap = Arrays.asList
//                ("...........+++++++........~~~~~~++....~~",
//                        "...........++++++.........~~~~~~+.....~~",
//                        "............++++...........~~~~~......++",
//                        "............+.+.............~~~.......++",
//                        "..........++~~~.......................++",
//                        ".........+++~~~....#######...........+++",
//                        ".........++++~.....#_____#.........+++++",
//                        "..........+++......#_____#........++++++",
//                        "..........+++......###_###.......~~+++++",
//                        "..........~~.....................~~...++",
//                        "..........~~~..................++.......",
//                        "...........~~....~~~~~.........++.......",
//                        "......~~....++..~~~~~~~~~~~......~......",
//                        "....+~~~~..++++++++~~~~~~~~~....~~~.....",
//                        "....+~~~~..++++++++~~~..~~~~~..~~~~~....");
//
//        GameMap burialGround = new GameMap(burialGroundFactory,burialGroundMap);
//        world.addGameMap(burialGround);

//        burialGround.at(21,11).setGround(new HollowSoldierGraveyard<HollowSoldier>(HollowSoldier.SPAWNER));

//        Gate abandonedVillageGate = new Gate();
        abandonedVillageGate.addTravelAction(new TravelAction(burialGround.at(22, 7),"The Burial Ground"));
//        theAbandonedVillage.at(31, 5).setGround(abandonedVillageGate);

//        Gate burialGroundGate = new Gate();
        burialGroundGate.addTravelAction(new TravelAction(theAbandonedVillage.at(31, 5),"The Abandoned Village"));
//        burialGround.at(23,7).setGround(burialGroundGate);


//        FancyGroundFactory ancientWoodsFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(), new Void());
//
//        List<String> ancientWoodsMap = Arrays.asList(
//                "....+++..............................+++++++++....~~~....~~~",
//                "+...+++..............................++++++++.....~~~.....~~",
//                "++...............#######..............++++.........~~.......",
//                "++...............#_____#...........................~~~......",
//                "+................#_____#............................~~......",
//                ".................###_###............~...............~~.....~",
//                "...............................~.+++~~..............~~....~~",
//                ".....................~........~~+++++...............~~~...~~",
//                "....................~~~.........++++............~~~~~~~...~~",
//                "....................~~~~.~~~~..........~........~~~~~~.....~",
//                "++++...............~~~~~~~~~~~........~~~.......~~~~~~......",
//                "+++++..............~~~~~~~~~~~........~~~........~~~~~......");
//
//
//        GameMap ancientWoods = new GameMap(ancientWoodsFactory,ancientWoodsMap);
//        world.addGameMap(ancientWoods);

        ForestEnemySpawnableGround<ForestEnemy> ancientWoodHuts = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> ancientWoodBush = new ForestBush(RedWolf.SPAWNER);
        ancientWoods.at(29,0).setGround(ancientWoodHuts);
        ancientWoods.at(15,11).setGround(ancientWoodBush);

        Gate burialGroundGate2 = new Gate();
        burialGroundGate2.addTravelAction(new TravelAction(ancientWoods.at(21, 4),"The Ancient Woods"));
        burialGround.at(30, 14).setGround(burialGroundGate2);

        Gate ancientWoodsGate = new Gate();
        ancientWoodsGate.addTravelAction(new TravelAction(burialGround.at(10, 14),"The Burial Ground"));
        ancientWoods.at(10,11).setGround(ancientWoodsGate);

        ancientWoods.at(10,7).addItem(new BloodBerry());
        ancientWoods.at(20,1).addItem(new BloodBerry());
        ancientWoods.at(15,6).addItem(new BloodBerry());
        ancientWoods.at(3,9).addItem(new BloodBerry());


//        FancyGroundFactory abxervyerFactory = new FancyGroundFactory(new Dirt(), new Puddle(), new Void());
//        List<String> abxervyerMap = Arrays.asList(
//                "~~~~.......+++......~+++++..............",
//                "~~~~.......+++.......+++++..............",
//                "~~~++......+++........++++..............",
//                "~~~++......++...........+..............+",
//                "~~~~~~...........+.......~~~++........++",
//                "~~~~~~..........++++....~~~~++++......++",
//                "~~~~~~...........+++++++~~~~.++++.....++",
//                "~~~~~..............++++++~~...+++.....++",
//                "......................+++......++.....++",
//                ".......................+~~............++",
//                ".......................~~~~...........++",
//                "........................~~++...........+",
//                ".....++++...............+++++...........",
//                ".....++++~..............+++++...........",
//                "......+++~~.............++++...........~",
//                ".......++..++++.......................~~",
//                "...........+++++......................~~",
//                "...........++++++.....................~~",
//                "..........~~+++++......................~",
//                ".........~~~~++++..................~~..~");
//
//        GameMap abxervyer = new GameMap(abxervyerFactory, abxervyerMap);
//        world.addGameMap(abxervyer);

        ForestEnemySpawnableGround<ForestEnemy> abxervyerHut1 = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerHut2 = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerBush1 = new ForestBush(RedWolf.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerBush2 = new ForestHut(ForestKeeper.SPAWNER);
        abxervyer.at(10, 19).setGround(abxervyerHut1);
        abxervyer.at(32, 0).setGround(abxervyerHut2);
        abxervyer.at(11, 13).setGround(abxervyerBush1);
        abxervyer.at(36, 18).setGround(abxervyerBush2);

        ArrayList<WeatherControllable> forestEnemySpawnableGroundList = new ArrayList<>();
        forestEnemySpawnableGroundList.add(ancientWoodHuts);
        forestEnemySpawnableGroundList.add(ancientWoodBush);
        forestEnemySpawnableGroundList.add(abxervyerHut1);
        forestEnemySpawnableGroundList.add(abxervyerHut2);
        forestEnemySpawnableGroundList.add(abxervyerBush1);
        forestEnemySpawnableGroundList.add(abxervyerBush2);

        Gate ancientWoodsGate2 = new Gate();
        ancientWoodsGate2.addTravelAction(new TravelAction(abxervyer.at(39, 13), "Abxervyer, The Forest Watcher"));
        ancientWoods.at(0, 6).setGround(ancientWoodsGate2);

        Gate abxvyerGate1 = new Gate();
        abxvyerGate1.addTravelAction(new TravelAction(ancientWoods.at(21, 4),"The Ancient Woods"));


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

        Traveller traveller = new Traveller();
        ancientWoods.at(20,3).addActor(traveller);

        WeatherManager weatherManager = new WeatherManager(Weather.SUNNY,forestEnemySpawnableGroundList);
        ForestWatcher forestWatcher = new ForestWatcher(weatherManager, abxvyerGate1);
        abxervyer.at((abxervyer.getXRange().max())/2,(abxervyer.getYRange().max())/2).addActor(forestWatcher);

//        FancyGroundFactory overgrownSanctuaryFactory = new FancyGroundFactory(new Dirt(), new Puddle(), new Void());
//
//        List<String> overgrownSanctuaryMap = Arrays.asList(
//                "++++.....++++........++++~~~~~.......~~~..........",
//                "++++......++.........++++~~~~.........~...........",
//                "+++..................+++++~~.......+++............",
//                "....................++++++......++++++............",
//                "...................++++........++++++~~...........",
//                "...................+++.........+++..~~~...........",
//                "..................+++..........++...~~~...........",
//                "~~~...........................~~~..~~~~...........",
//                "~~~~............+++..........~~~~~~~~~~...........",
//                "~~~~............+++.........~~~~~~~~~~~~..........",
//                "++~..............+++.......+~~........~~..........",
//                "+++..............+++......+++..........~~.........",
//                "+++..............+++......+++..........~~.........",
//                "~~~..............+++......+++..........~~~........",
//                "~~~~.............+++......+++..........~~~........");
//
//        GameMap overgrownSanctuary = new GameMap(overgrownSanctuaryFactory, overgrownSanctuaryMap);
//        world.addGameMap(overgrownSanctuary);

        abxvyerGate1.addTravelAction(new TravelAction(overgrownSanctuary.at(8, 4),"The Overgrown Sanctuary"));

        Gate overgrownSanctuaryGate1 = new Gate();
        overgrownSanctuaryGate1.addTravelAction(new TravelAction(abxervyer.at(39, 13), "Abxervyer, The Forest Watcher"));
        overgrownSanctuary.at(7, 4).setGround(overgrownSanctuaryGate1);

        overgrownSanctuary.at(5,11).setGround(new HollowSoldierGraveyard<HollowSoldier>(HollowSoldier.SPAWNER));
        SanctuaryEnemySpawnableGround<SanctuaryEnemy> overgrownSanctuaryHut = new SanctuaryHut(EldentreeGuardian.SPAWNER);
        SanctuaryEnemySpawnableGround<SanctuaryEnemy> overgrownSanctuaryBush = new SanctuaryBush(LivingBranch.SPAWNER);
        overgrownSanctuary.at(9, 7).setGround(overgrownSanctuaryHut);
        overgrownSanctuary.at(22, 7).setGround(overgrownSanctuaryBush);

        Blacksmith blacksmith = new Blacksmith();
        theAbandonedVillage.at(27,5).addActor(blacksmith);
        Player player = new Player("The Abstracted One", '@', 150, 200);
        world.addPlayer(player,theAbandonedVillage.at(29, 5));
        world.run();
    }
}


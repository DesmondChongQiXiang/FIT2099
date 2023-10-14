package game;

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
import game.grounds.environments.village.HollowSoldierGraveyard;
import game.grounds.environments.village.WanderingUndeadGraveyard;
import game.items.BloodBerry;
import game.weapons.Broadsword;
import game.weapons.GiantHammer;
import game.weathers.Weather;
import game.weathers.WeatherControllable;
import game.weathers.WeatherManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Designborne {

    private World world;
    private HashMap<String,GameMap> gameMapHashMap = new HashMap<>();
    private ArrayList<WeatherControllable> forestEnemySpawnableGroundList;

    public Designborne(World world) {
        this.world = world;
        this.forestEnemySpawnableGroundList = new ArrayList<>();
    }

    public void createGameMap(){
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
        gameMapHashMap.put("The Abandoned Village",theAbandonedVillage);
        world.addGameMap(theAbandonedVillage);

        FancyGroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(),new Void());
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
        gameMapHashMap.put("The Burial Ground",burialGround);
        world.addGameMap(burialGround);

        FancyGroundFactory ancientWoodsFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(), new Void());

        List<String> ancientWoodsMap = Arrays.asList(
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


        GameMap ancientWoods = new GameMap(ancientWoodsFactory,ancientWoodsMap);
        gameMapHashMap.put("The Ancient Woods",ancientWoods);
        world.addGameMap(ancientWoods);

        FancyGroundFactory abxervyerFactory = new FancyGroundFactory(new Dirt(), new Puddle(), new Void());
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
        gameMapHashMap.put("The Abxervyer",abxervyer);
        world.addGameMap(abxervyer);

        FancyGroundFactory overgrownSanctuaryFactory = new FancyGroundFactory(new Dirt(), new Puddle(), new Void());

        List<String> overgrownSanctuaryMap = Arrays.asList(
                "++++.....++++........++++~~~~~.......~~~..........",
                "++++......++.........++++~~~~.........~...........",
                "+++..................+++++~~.......+++............",
                "....................++++++......++++++............",
                "...................++++........++++++~~...........",
                "...................+++.........+++..~~~...........",
                "..................+++..........++...~~~...........",
                "~~~...........................~~~..~~~~...........",
                "~~~~............+++..........~~~~~~~~~~...........",
                "~~~~............+++.........~~~~~~~~~~~~..........",
                "++~..............+++.......+~~........~~..........",
                "+++..............+++......+++..........~~.........",
                "+++..............+++......+++..........~~.........",
                "~~~..............+++......+++..........~~~........",
                "~~~~.............+++......+++..........~~~........");

        GameMap overgrownSanctuary = new GameMap(overgrownSanctuaryFactory, overgrownSanctuaryMap);
        gameMapHashMap.put("The Overgrown Sanctuary",overgrownSanctuary);
        world.addGameMap(overgrownSanctuary);
    }

    public void createGround() {
        gameMapHashMap.get("The Abandoned Village").at(10,8).setGround(new WanderingUndeadGraveyard<WanderingUndead>(WanderingUndead.SPAWNER));

        gameMapHashMap.get("The Burial Ground").at(21,11).setGround(new HollowSoldierGraveyard<HollowSoldier>(HollowSoldier.SPAWNER));
        Gate abandonedVillageGate = new Gate();
        gameMapHashMap.get("The Abandoned Village").at(31, 5).setGround(abandonedVillageGate);
        abandonedVillageGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(22, 7),"The Burial Ground"));
        Gate burialGroundGate = new Gate();
        gameMapHashMap.get("The Burial Ground").at(23,7).setGround(burialGroundGate);
        burialGroundGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Abandoned Village").at(31, 5),"The Abandoned Village"));

        ForestEnemySpawnableGround<ForestEnemy> ancientWoodHuts = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> ancientWoodBush = new ForestBush(RedWolf.SPAWNER);
        gameMapHashMap.get("The Ancient Woods").at(29,0).setGround(ancientWoodHuts);
        gameMapHashMap.get("The Ancient Woods").at(15,11).setGround(ancientWoodBush);
        Gate burialGroundGate2 = new Gate();
        burialGroundGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
        gameMapHashMap.get("The Burial Ground").at(30, 14).setGround(burialGroundGate2);
        Gate ancientWoodsGate = new Gate();
        ancientWoodsGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(10, 14),"The Burial Ground"));
        gameMapHashMap.get("The Ancient Woods").at(10,11).setGround(ancientWoodsGate);

        ForestEnemySpawnableGround<ForestEnemy> abxervyerHut1 = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerHut2 = new ForestHut(ForestKeeper.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerBush1 = new ForestBush(RedWolf.SPAWNER);
        ForestEnemySpawnableGround<ForestEnemy> abxervyerBush2 = new ForestHut(ForestKeeper.SPAWNER);
        gameMapHashMap.get("The Abxervyer").at(10, 19).setGround(abxervyerHut1);
        gameMapHashMap.get("The Abxervyer").at(32, 0).setGround(abxervyerHut2);
        gameMapHashMap.get("The Abxervyer").at(11, 13).setGround(abxervyerBush1);
        gameMapHashMap.get("The Abxervyer").at(36, 18).setGround(abxervyerBush2);
        forestEnemySpawnableGroundList.add(ancientWoodHuts);
        forestEnemySpawnableGroundList.add(ancientWoodBush);
        forestEnemySpawnableGroundList.add(abxervyerHut1);
        forestEnemySpawnableGroundList.add(abxervyerHut2);
        forestEnemySpawnableGroundList.add(abxervyerBush1);
        forestEnemySpawnableGroundList.add(abxervyerBush2);
        Gate ancientWoodsGate2 = new Gate();
        ancientWoodsGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Ancient Woods").at(0, 6).setGround(ancientWoodsGate2);
//        Gate abxvyerGate1 = new Gate();
//        abxvyerGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
//
//        abxvyerGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Overgrown Sanctuary").at(8, 4),"The Overgrown Sanctuary"));
        Gate overgrownSanctuaryGate1 = new Gate();
        overgrownSanctuaryGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Overgrown Sanctuary").at(7, 4).setGround(overgrownSanctuaryGate1);
        gameMapHashMap.get("The Overgrown Sanctuary").at(5,11).setGround(new HollowSoldierGraveyard<HollowSoldier>(HollowSoldier.SPAWNER));
        SanctuaryEnemySpawnableGround<SanctuaryEnemy> overgrownSanctuaryHut = new SanctuaryHut(EldentreeGuardian.SPAWNER);
        SanctuaryEnemySpawnableGround<SanctuaryEnemy> overgrownSanctuaryBush = new SanctuaryBush(LivingBranch.SPAWNER);
        gameMapHashMap.get("The Overgrown Sanctuary").at(9, 7).setGround(overgrownSanctuaryHut);
        gameMapHashMap.get("The Overgrown Sanctuary").at(22, 7).setGround(overgrownSanctuaryBush);
    }

    public void createItem() {
        Item broadsword = new Broadsword();
        gameMapHashMap.get("The Abandoned Village").at(27, 6).addItem(broadsword);

        gameMapHashMap.get("The Ancient Woods").at(10,7).addItem(new BloodBerry());
        gameMapHashMap.get("The Ancient Woods").at(20,1).addItem(new BloodBerry());
        gameMapHashMap.get("The Ancient Woods").at(15,6).addItem(new BloodBerry());
        gameMapHashMap.get("The Ancient Woods").at(3,9).addItem(new BloodBerry());

        GiantHammer giantHammer = new GiantHammer();
        gameMapHashMap.get("The Abxervyer").at(39, 12).addItem(giantHammer);
    }

    public void createActor() {
        Player player = new Player("The Abstracted One", '@', 150, 200);
        world.addPlayer(player,gameMapHashMap.get("The Abandoned Village").at(29, 5));

        Blacksmith blacksmith = new Blacksmith();
        gameMapHashMap.get("The Abandoned Village").at(27,5).addActor(blacksmith);

        Traveller traveller = new Traveller();
        gameMapHashMap.get("The Ancient Woods").at(20,3).addActor(traveller);

        Gate abxvyerGate1 = new Gate();
        abxvyerGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
        abxvyerGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Overgrown Sanctuary").at(8, 4),"The Overgrown Sanctuary"));
        WeatherManager weatherManager = new WeatherManager(Weather.SUNNY,forestEnemySpawnableGroundList);
        ForestWatcher forestWatcher = new ForestWatcher(weatherManager, abxvyerGate1);
        gameMapHashMap.get("The Abxervyer").at((gameMapHashMap.get("The Abxervyer").getXRange().max())/2,(gameMapHashMap.get("The Abxervyer").getYRange().max())/2).addActor(forestWatcher);
    }

    public void showMessage(){
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public World getWorld() {
        return world;
    }
}

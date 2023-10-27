package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actions.TravelAction;
import game.actors.Blacksmith;
import game.actors.Player;
import game.actors.Traveller;
import game.actors.enemies.ForestWatcher;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.environments.Bush;
import game.grounds.environments.EnemySpawnableGround;
import game.grounds.environments.Graveyard;
import game.grounds.environments.Hut;
import game.items.BloodBerry;
import game.reset.ResetManager;
import game.spawners.*;
import game.weapons.Broadsword;
import game.weapons.GiantHammer;
import game.weathers.Weather;
import game.weathers.WeatherManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Designborne {
    private World world;
    private HashMap<String,GameMap> gameMapHashMap;

    public Designborne(World world) {
        this.world = world;
        this.gameMapHashMap = new HashMap<>();
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
        EnemySpawnableGround abandonedVillageGraveyard = new Graveyard(new WanderingUndeadSpawner());
        gameMapHashMap.get("The Abandoned Village").at(10,8).setGround(abandonedVillageGraveyard);
        ResetManager.getInstance().registerResetNotifiable(abandonedVillageGraveyard);

        EnemySpawnableGround burialGroundGraveyard = new Graveyard(new HollowSoldierSpawner());
        gameMapHashMap.get("The Burial Ground").at(21,11).setGround(burialGroundGraveyard);
        ResetManager.getInstance().registerResetNotifiable(burialGroundGraveyard);

        Gate abandonedVillageGate = new Gate();
        gameMapHashMap.get("The Abandoned Village").at(31, 5).setGround(abandonedVillageGate);
        abandonedVillageGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(22, 7),"The Burial Ground"));
        ResetManager.getInstance().registerResetNotifiable(abandonedVillageGate);

        Gate burialGroundGate = new Gate();
        gameMapHashMap.get("The Burial Ground").at(23,7).setGround(burialGroundGate);
        burialGroundGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Abandoned Village").at(31, 5),"The Abandoned Village"));
        ResetManager.getInstance().registerResetNotifiable(burialGroundGate);

        ForestKeeperSpawner forestKeeperSpawner1 = new ForestKeeperSpawner();
        EnemySpawnableGround ancientWoodHut = new Hut(forestKeeperSpawner1);
        gameMapHashMap.get("The Ancient Woods").at(29,0).setGround(ancientWoodHut);
        WeatherManager.getInstance().registerWeatherControllable(forestKeeperSpawner1);
        ResetManager.getInstance().registerResetNotifiable(ancientWoodHut);

        RedWolfSpawner redWolfSpawner1 = new RedWolfSpawner();
        EnemySpawnableGround ancientWoodBush = new Bush(redWolfSpawner1);
        gameMapHashMap.get("The Ancient Woods").at(15,11).setGround(ancientWoodBush);
        WeatherManager.getInstance().registerWeatherControllable(redWolfSpawner1);
        ResetManager.getInstance().registerResetNotifiable(ancientWoodBush);

        Gate burialGroundGate2 = new Gate();
        burialGroundGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
        gameMapHashMap.get("The Burial Ground").at(30, 14).setGround(burialGroundGate2);
        ResetManager.getInstance().registerResetNotifiable(burialGroundGate2);

        Gate ancientWoodsGate = new Gate();
        ancientWoodsGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(10, 14),"The Burial Ground"));
        gameMapHashMap.get("The Ancient Woods").at(10,11).setGround(ancientWoodsGate);
        ResetManager.getInstance().registerResetNotifiable(ancientWoodsGate);

        ForestKeeperSpawner forestKeeperSpawner2 = new ForestKeeperSpawner();
        EnemySpawnableGround abxervyerHut1 = new Hut(forestKeeperSpawner2);
        gameMapHashMap.get("The Abxervyer").at(10, 19).setGround(abxervyerHut1);
        WeatherManager.getInstance().registerWeatherControllable(forestKeeperSpawner2);
        ResetManager.getInstance().registerResetNotifiable(abxervyerHut1);

        ForestKeeperSpawner forestKeeperSpawner3 = new ForestKeeperSpawner();
        EnemySpawnableGround abxervyerHut2 = new Hut(forestKeeperSpawner3);
        gameMapHashMap.get("The Abxervyer").at(32, 0).setGround(abxervyerHut2);
        WeatherManager.getInstance().registerWeatherControllable(forestKeeperSpawner3);
        ResetManager.getInstance().registerResetNotifiable(abxervyerHut2);

        RedWolfSpawner redWolfSpawner2 = new RedWolfSpawner();
        EnemySpawnableGround abxervyerBush1 = new Bush(redWolfSpawner2);
        gameMapHashMap.get("The Abxervyer").at(11, 13).setGround(abxervyerBush1);
        WeatherManager.getInstance().registerWeatherControllable(redWolfSpawner2);
        ResetManager.getInstance().registerResetNotifiable(abxervyerBush1);

        ForestKeeperSpawner forestKeeperSpawner4 = new ForestKeeperSpawner();
        EnemySpawnableGround abxervyerBush2 = new Hut(forestKeeperSpawner4);
        gameMapHashMap.get("The Abxervyer").at(36, 18).setGround(abxervyerBush2);
        WeatherManager.getInstance().registerWeatherControllable(forestKeeperSpawner4);
        ResetManager.getInstance().registerResetNotifiable(abxervyerBush2);

        Gate ancientWoodsGate2 = new Gate();
        ancientWoodsGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Ancient Woods").at(0, 6).setGround(ancientWoodsGate2);
        ResetManager.getInstance().registerResetNotifiable(ancientWoodsGate2);

        Gate overgrownSanctuaryGate1 = new Gate();
        overgrownSanctuaryGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Overgrown Sanctuary").at(7, 4).setGround(overgrownSanctuaryGate1);
        ResetManager.getInstance().registerResetNotifiable(overgrownSanctuaryGate1);

        EnemySpawnableGround overgrownSanctuaryGraveyard = new Graveyard(new HollowSoldierSpawner());
        gameMapHashMap.get("The Overgrown Sanctuary").at(5,11).setGround(overgrownSanctuaryGraveyard);
        ResetManager.getInstance().registerResetNotifiable(overgrownSanctuaryGraveyard);

        EnemySpawnableGround overgrownSanctuaryHut = new Hut(new EldentreeGuardianSpawner());
        gameMapHashMap.get("The Overgrown Sanctuary").at(9, 7).setGround(overgrownSanctuaryHut);
        ResetManager.getInstance().registerResetNotifiable(overgrownSanctuaryHut);

        EnemySpawnableGround overgrownSanctuaryBush = new Bush(new LivingBranchSpawner());
        gameMapHashMap.get("The Overgrown Sanctuary").at(22, 7).setGround(overgrownSanctuaryBush);
        ResetManager.getInstance().registerResetNotifiable(overgrownSanctuaryBush);
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
        Location spawnPlayerLocation = gameMapHashMap.get("The Abandoned Village").at(29, 5);
        world.addPlayer(player,spawnPlayerLocation);
        player.addSpawnLocation(spawnPlayerLocation);
        Blacksmith blacksmith = new Blacksmith();
        gameMapHashMap.get("The Abandoned Village").at(27,5).addActor(blacksmith);

        Traveller traveller = new Traveller();
        gameMapHashMap.get("The Ancient Woods").at(20,3).addActor(traveller);

        ForestWatcher forestWatcher = new ForestWatcher(createForestWatcherGate());
        gameMapHashMap.get("The Abxervyer").at((gameMapHashMap.get("The Abxervyer").getXRange().max())/2,(gameMapHashMap.get("The Abxervyer").getYRange().max())/2).addActor(forestWatcher);
        ResetManager.getInstance().registerResetNotifiable(forestWatcher);
    }

    public Gate createForestWatcherGate() {
        Gate abxvyerGate = new Gate();
        abxvyerGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
        abxvyerGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Overgrown Sanctuary").at(8, 4),"The Overgrown Sanctuary"));
        return abxvyerGate;
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


    public void run() {
        createGameMap();
        createItem();
        createGround();
        createActor();
        showMessage();
        world.run();
    }

}

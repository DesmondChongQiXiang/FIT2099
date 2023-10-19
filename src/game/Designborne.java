package game;

import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
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
import game.actors.enemies.ForestKeeper;
import game.actors.enemies.RedWolf;
import game.actors.enemies.EldentreeGuardian;
import game.actors.enemies.LivingBranch;
import game.actors.enemies.HollowSoldier;
import game.actors.enemies.WanderingUndead;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.environments.EnemySpawnableGround;
import game.grounds.environments.ForestBush;
import game.grounds.environments.ForestHut;
import game.grounds.environments.SanctuaryBush;
import game.grounds.environments.SanctuaryHut;
import game.grounds.environments.HollowSoldierGraveyard;
import game.grounds.environments.WanderingUndeadGraveyard;
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
    private HashMap<String,GameMap> gameMapHashMap;
    private ArrayList<EnemySpawnableGround> enemySpawnableGroundList;
    private ArrayList<Gate> gateList;
    private ArrayList<WeatherControllable> forestEnemySpawnableGroundList;
    private Player player;
    private ForestWatcher forestWatcher;

    public Designborne(World world) {
        this.world = world;
        this.gameMapHashMap = new HashMap<>();
        this.enemySpawnableGroundList = new ArrayList<>();
        this.forestEnemySpawnableGroundList = new ArrayList<>();
        this.player = new Player("The Abstracted One", '@', 150, 200);
        this.gateList = new ArrayList<>();
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
        EnemySpawnableGround<WanderingUndead> abandonedVillageGraveyard = new WanderingUndeadGraveyard<>(WanderingUndead.SPAWNER);
        gameMapHashMap.get("The Abandoned Village").at(10,8).setGround(abandonedVillageGraveyard);
        enemySpawnableGroundList.add(abandonedVillageGraveyard);

        EnemySpawnableGround<HollowSoldier> burialGroundGraveyard = new HollowSoldierGraveyard<HollowSoldier>(HollowSoldier.SPAWNER);
        gameMapHashMap.get("The Burial Ground").at(21,11).setGround(burialGroundGraveyard);
        enemySpawnableGroundList.add(burialGroundGraveyard);

        Gate abandonedVillageGate = new Gate();
        gameMapHashMap.get("The Abandoned Village").at(31, 5).setGround(abandonedVillageGate);
        abandonedVillageGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(22, 7),"The Burial Ground"));
        gateList.add(abandonedVillageGate);

        Gate burialGroundGate = new Gate();
        gameMapHashMap.get("The Burial Ground").at(23,7).setGround(burialGroundGate);
        burialGroundGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Abandoned Village").at(31, 5),"The Abandoned Village"));
        gateList.add(burialGroundGate);

        ForestHut<ForestKeeper> ancientWoodHut = new ForestHut<>(ForestKeeper.SPAWNER);
        gameMapHashMap.get("The Ancient Woods").at(29,0).setGround(ancientWoodHut);
        forestEnemySpawnableGroundList.add(ancientWoodHut);
        enemySpawnableGroundList.add(ancientWoodHut);

        ForestBush<RedWolf> ancientWoodBush = new ForestBush<>(RedWolf.SPAWNER);
        gameMapHashMap.get("The Ancient Woods").at(15,11).setGround(ancientWoodBush);
        forestEnemySpawnableGroundList.add(ancientWoodBush);
        enemySpawnableGroundList.add(ancientWoodBush);

        Gate burialGroundGate2 = new Gate();
        burialGroundGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Ancient Woods").at(21, 4),"The Ancient Woods"));
        gameMapHashMap.get("The Burial Ground").at(30, 14).setGround(burialGroundGate2);
        gateList.add(burialGroundGate2);

        Gate ancientWoodsGate = new Gate();
        ancientWoodsGate.addTravelAction(new TravelAction(gameMapHashMap.get("The Burial Ground").at(10, 14),"The Burial Ground"));
        gameMapHashMap.get("The Ancient Woods").at(10,11).setGround(ancientWoodsGate);
        gateList.add(ancientWoodsGate);

        ForestHut<ForestKeeper> abxervyerHut1 = new ForestHut<>(ForestKeeper.SPAWNER);
        gameMapHashMap.get("The Abxervyer").at(10, 19).setGround(abxervyerHut1);
        forestEnemySpawnableGroundList.add(abxervyerHut1);
        enemySpawnableGroundList.add(abxervyerHut1);

        ForestHut<ForestKeeper> abxervyerHut2 = new ForestHut<>(ForestKeeper.SPAWNER);
        gameMapHashMap.get("The Abxervyer").at(32, 0).setGround(abxervyerHut2);
        forestEnemySpawnableGroundList.add(abxervyerHut2);
        enemySpawnableGroundList.add(abxervyerHut2);

        ForestBush<RedWolf> abxervyerBush1 = new ForestBush<>(RedWolf.SPAWNER);
        gameMapHashMap.get("The Abxervyer").at(11, 13).setGround(abxervyerBush1);
        forestEnemySpawnableGroundList.add(abxervyerBush1);
        enemySpawnableGroundList.add(abxervyerBush1);

        ForestHut<ForestKeeper> abxervyerBush2 = new ForestHut<>(ForestKeeper.SPAWNER);
        gameMapHashMap.get("The Abxervyer").at(36, 18).setGround(abxervyerBush2);
        forestEnemySpawnableGroundList.add(abxervyerBush2);
        enemySpawnableGroundList.add(abxervyerBush2);

        Gate ancientWoodsGate2 = new Gate();
        ancientWoodsGate2.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Ancient Woods").at(0, 6).setGround(ancientWoodsGate2);
        gateList.add(ancientWoodsGate2);

        Gate overgrownSanctuaryGate1 = new Gate();
        overgrownSanctuaryGate1.addTravelAction(new TravelAction(gameMapHashMap.get("The Abxervyer").at(39, 13), "Abxervyer, The Forest Watcher"));
        gameMapHashMap.get("The Overgrown Sanctuary").at(7, 4).setGround(overgrownSanctuaryGate1);
        gateList.add(overgrownSanctuaryGate1);

        EnemySpawnableGround<HollowSoldier> overgrownSanctuaryGraveyard = new HollowSoldierGraveyard<>(HollowSoldier.SPAWNER);
        gameMapHashMap.get("The Overgrown Sanctuary").at(5,11).setGround(overgrownSanctuaryGraveyard);
        enemySpawnableGroundList.add(overgrownSanctuaryGraveyard);

        EnemySpawnableGround<EldentreeGuardian> overgrownSanctuaryHut = new SanctuaryHut<>(EldentreeGuardian.SPAWNER);
        gameMapHashMap.get("The Overgrown Sanctuary").at(9, 7).setGround(overgrownSanctuaryHut);
        enemySpawnableGroundList.add(overgrownSanctuaryHut);

        EnemySpawnableGround<LivingBranch> overgrownSanctuaryBush = new SanctuaryBush<>(LivingBranch.SPAWNER);
        gameMapHashMap.get("The Overgrown Sanctuary").at(22, 7).setGround(overgrownSanctuaryBush);
        enemySpawnableGroundList.add(overgrownSanctuaryBush);
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
        world.addPlayer(player,gameMapHashMap.get("The Abandoned Village").at(29, 5));

        Blacksmith blacksmith = new Blacksmith();
        gameMapHashMap.get("The Abandoned Village").at(27,5).addActor(blacksmith);

        Traveller traveller = new Traveller();
        gameMapHashMap.get("The Ancient Woods").at(20,3).addActor(traveller);

        WeatherManager weatherManager = new WeatherManager(Weather.SUNNY,forestEnemySpawnableGroundList);
        this.forestWatcher = new ForestWatcher(weatherManager, createForestWatcherGate());
        gameMapHashMap.get("The Abxervyer").at((gameMapHashMap.get("The Abxervyer").getXRange().max())/2,(gameMapHashMap.get("The Abxervyer").getYRange().max())/2).addActor(forestWatcher);
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

    public void respawnPlayer(){
        player.heal(player.getAttributeMaximum(BaseActorAttributes.HEALTH));
        player.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.UPDATE, player.getAttributeMaximum(BaseActorAttributes.STAMINA));
        gameMapHashMap.get("The Abandoned Village").moveActor(player, gameMapHashMap.get("The Abandoned Village").at(29,5));
    }

    public World getWorld() {
        return world;
    }

    public void playerDead(){
        for(EnemySpawnableGround enemySpawnableGround:enemySpawnableGroundList){
            enemySpawnableGround.setPlayerDead();
        }
        for (GameMap map : gameMapHashMap.values()){
            map.tick();
        }
        for(Gate gate:gateList){
            gate.lockGate();
        }
        forestWatcher.heal(forestWatcher.getAttributeMaximum(BaseActorAttributes.HEALTH));
    }
}

package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Puddle;
import game.grounds.Void;
import game.grounds.Wall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Designborne {

    private World world;
    private HashMap<String,GameMap> gameMapHashMap = new HashMap<>();

    public Designborne(World world) {
        this.world = world;
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




}

package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.*;
import game.actions.TravelMapAction;
import game.actors.enemies.HollowSoldier;
import game.actors.Player;
import game.actors.enemies.WanderingUndead;
import game.displays.FancyMessage;
import game.grounds.*;
import game.grounds.Void;
import game.grounds.gates.BurialLockedGate;
import game.grounds.gates.Gate;
import game.grounds.gates.VillageLockedGate;
import game.maps.BurialGround;
import game.maps.TheAbandonedVillage;
import game.items.weapons.BroadSword;
import game.spawners.HollowSoldierSpawner;
import game.spawners.Spawner;
import game.spawners.WanderingUndeadSpawner;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Ong Chong How
 *
 * @version 1.0
 *
 */
public class Application {

    /**
     * The main method that starts the game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        GroundFactory villageGroundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

        GroundFactory burialGroundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Void());

        List<String> villageMap = Arrays.asList(
                "...........................................................",
                "...#######.................................................",
                "...#__.....................................................",
                "...#..___#.................................................",
                "...###.###................#######..........................",
                "..........................#_____#..........................",
                "........~~................#_____#..........................",
                ".........~~~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~.................................###..##..........",
                "~~~~~~~...................................#___..#..........",
                "~~~~~~....................................#..___#..........",
                "~~~~~~~~~.................................#######..........");

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

        GameMap village = new TheAbandonedVillage(villageGroundFactory, villageMap);
        world.addGameMap(village);

        GameMap burialGround = new BurialGround(burialGroundFactory, burialGroundMap);
        world.addGameMap(burialGround);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Item broadSword = new BroadSword("Broadsword", '1', 110, "slashes", 80);
        village.at(27,6).addItem(broadSword);

        Ground voidGround = new Void();
        village.at(20,8).setGround(voidGround);
        village.at(13,9).setGround(voidGround);
        village.at(9,4).setGround(voidGround);
        village.at(10,7).setGround(voidGround);

        Spawner wanderingUndeadSpawner = new WanderingUndeadSpawner();
        Ground villageGraveyard = new Graveyard(wanderingUndeadSpawner);
        village.at(24,9).setGround(villageGraveyard);
        village.at(50,3).setGround(villageGraveyard);

        Spawner hollowSoldierSpawner = new HollowSoldierSpawner();
        Ground burialGraveyard = new Graveyard(hollowSoldierSpawner);
        burialGround.at(24,9).setGround(burialGraveyard);
        burialGround.at(11,6).setGround(burialGraveyard);

        Gate villageLockedGate = new VillageLockedGate();
        villageLockedGate.addSampleAction(new TravelMapAction(burialGround.at(22, 6)));
        village.at(30,0).setGround(villageLockedGate);

        Gate burialLockedGate = new BurialLockedGate();
        burialLockedGate.addSampleAction(new TravelMapAction(village.at(31,0)));
        burialGround.at(23,6).setGround(burialLockedGate);

        Actor wanderingUndead = new WanderingUndead();
        village.at(23, 10).addActor(wanderingUndead);

        Actor hollowSoldier = new HollowSoldier();
        burialGround.at(23, 10).addActor(hollowSoldier);

        Actor player = new Player("The Abstracted One", '@', 150, 200);
        world.addPlayer(player, village.at(29, 5));

        world.run();
    }
}

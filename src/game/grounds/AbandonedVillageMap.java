package game.grounds;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.enemies.villageenemy.WanderingUndead;
import game.grounds.environments.village.WanderingUndeadGraveyard;
import game.items.*;
import game.weapons.Broadsword;

import java.util.Arrays;
import java.util.List;

public class AbandonedVillageMap {

    private GameMap theAbandonedVillage;
    public GameMap getTheAbandonedVillage() {
        return this.theAbandonedVillage;
    }

    public AbandonedVillageMap(World world) {
        FancyGroundFactory abandonedVillageFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Void());

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
        theAbandonedVillage = new GameMap(abandonedVillageFactory, abandonedVillage);
        world.addGameMap(theAbandonedVillage);

        initializeElements();
    }

    private void initializeElements() {
        theAbandonedVillage.at(10, 8).setGround(new WanderingUndeadGraveyard<>(WanderingUndead.SPAWNER));

        Item broadsword = new Broadsword();
        theAbandonedVillage.at(27, 6).addItem(broadsword);
    }
}


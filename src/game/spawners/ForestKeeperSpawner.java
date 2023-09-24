package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.ForestKeeper;
import game.actors.enemies.WanderingUndead;

import java.util.Random;

public class ForestKeeperSpawner implements Spawner{
    /**
     * Spawn the Wandering Undead enemy
     *
     * @param location the location of spawn the enemy
     */
    @Override
    public void spawn(Location location){
        if (Math.random() * 100 <= 15 && !location.containsAnActor()) {
            location.addActor(new ForestKeeper());
        }
    }
}

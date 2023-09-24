package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;

import java.util.Random;
/**
 * A class that represents spawner of Wandering Undead
 */
public class WanderingUndeadSpawner implements Spawner{
    /**
     * Spawn the Wandering Undead enemy
     *
     * @param location the location of spawn the enemy
     */
    @Override
    public void spawn(Location location){
        if (Math.random() * 100 <= 25 && !location.containsAnActor()) {
            location.addActor(new WanderingUndead());
        }
    }
}

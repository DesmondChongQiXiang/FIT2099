package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;

import java.util.Random;

/**
 * The WanderingUndeadSpawner class is responsible for spawning WanderingUndead actors in the game world.
 * It implements the Spawner interface to define the logic for creating and placing WanderingUndead actors
 * at specified locations within a game map.
 *
 * @author Ong Chong How
 *
 * @see Spawner
 * @see edu.monash.fit2099.engine.positions.Location
 * @see game.actors.enemies.WanderingUndead
 *
 * @version 1.0
 */
public class WanderingUndeadSpawner implements Spawner {

    /**
     * Spawns WanderingUndead actors at a specified location within the game map.
     *
     * This method randomly determines whether to spawn a WanderingUndead actor at the given location based on a
     * predefined probability.
     *
     * @param location The location within the game map where the WanderingUndead actors should be spawned.
     */
    @Override
    public void spawn(Location location) {

        // Determine whether to spawn a WanderingUndead based on a predefined probability
        if(Math.random() <= 0.25){
            boolean isEnable = false;

            // Find an available spawn location within exits
            while(!isEnable){
                Location spawnlocation = location.getExits().get(new Random().nextInt(location.getExits().size())).getDestination();
                if(!(spawnlocation.containsAnActor())){
                    spawnlocation.addActor(new WanderingUndead());
                    isEnable = true;
                }
            }
        }
    }
}

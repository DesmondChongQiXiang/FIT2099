package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;

import java.util.Random;

/**
 * The HollowSoldierSpawner class is responsible for spawning HollowSoldier actors on specific game maps.
 * It implements the Spawner interface, defining a method to spawn actors at a given location within the map.
 *
 * This spawner has a 10% chance of spawning a HollowSoldier actor in a randomly selected adjacent location.
 *
 * @author Ong Chong How
 *
 * @see edu.monash.fit2099.engine.positions.Location
 * @see game.actors.enemies.HollowSoldier
 *
 * @version 1.0
 */
public class HollowSoldierSpawner implements Spawner {

    /**
     * Spawns a HollowSoldier actor at a specified location within the game map.
     *
     * This method randomly selects an adjacent location from the provided location and attempts to spawn a
     * HollowSoldier actor there with a 10% chance. If the selected location is occupied, it will continue to
     * select other locations until it successfully spawns the actor.
     *
     * @param location The location within the game map where the actor should be spawned.
     */
    @Override
    public void spawn(Location location) {
        if(Math.random() <= 0.10){
            boolean isEnable = false;
            while(!isEnable){
                Location spawnlocation = location.getExits().get(new Random().nextInt(location.getExits().size())).getDestination();
                if(!(spawnlocation.containsAnActor())){
                    spawnlocation.addActor(new HollowSoldier());
                    isEnable = true;
                }
            }
        }
    }
}

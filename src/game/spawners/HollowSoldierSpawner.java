package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;

import java.util.Random;

/**
 * A class that represents spawner of Hollow Soldier
 */
public class HollowSoldierSpawner implements Spawner{
    private Random rand = new Random();
    /**
     * Spawn the Hollow Soldier enemy
     *
     * @param location the location of spawn the enemy
     */
    @Override
    public void spawn(Location location){
        if (Math.random() * 100 <= 10) {
            Location chosenExit;
            HollowSoldier hollowSoldier = new HollowSoldier();
            do{
                chosenExit = location.getExits().get(rand.nextInt(location.getExits().size())).getDestination();
            }while(!chosenExit.canActorEnter(hollowSoldier) && chosenExit.containsAnActor());
            chosenExit.addActor(hollowSoldier);
        }
    }
}

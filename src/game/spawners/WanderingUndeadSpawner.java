package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;

import java.util.Random;
/**
 * A class that represents spawner of Wandering Undead
 */
public class WanderingUndeadSpawner implements Spawner{
    private Random rand = new Random();
    /**
     * Spawn the Wandering Undead enemy
     *
     * @param location the location of spawn the enemy
     */
    @Override
    public void spawn(Location location){
        if (Math.random() * 100 <= 25) {
            Location chosenExit;
            WanderingUndead wanderingUndead = new WanderingUndead();
            do{
                chosenExit = location.getExits().get(rand.nextInt(location.getExits().size())).getDestination();
            }while(!chosenExit.canActorEnter(wanderingUndead) && chosenExit.containsAnActor());
            chosenExit.addActor(wanderingUndead);
        }
    }
}

package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;

/**
 * A class that represents a graveyard in the game world.
 * This ground type is represented by the character 'n' in the game.
 * Actors can enter this ground, and it has a spawner that spawns entities in the graveyard over time.
 *
 * @author Ong Chong How
 * @version 1.0
 */
public class Graveyard extends Ground {

    private Spawner spawner;

    /**
     * Constructor to create a Graveyard object.
     *
     * @param spawner The spawner responsible for spawning entities in the graveyard.
     */
    public Graveyard(Spawner spawner) {
        super('n');
        this.spawner = spawner;
    }

    /**
     * Checks if an actor can enter this graveyard.
     *
     * @param actor The actor attempting to enter.
     * @return Always returns true, indicating that actors can enter the graveyard.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return true;
    }

    /**
     * Called on each game tick to perform actions associated with the graveyard.
     * This method invokes the spawner to spawn entities in the graveyard.
     *
     * @param location The location of the graveyard in the game world.
     */
    @Override
    public void tick(Location location) {
        spawner.spawn(location);
    }
}

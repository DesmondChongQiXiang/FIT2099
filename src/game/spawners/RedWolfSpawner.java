package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HollowSoldier;
import game.actors.enemies.RedWolf;

public class RedWolfSpawner implements Spawner{
    /**
     * Spawn the Red Wolf enemy
     *
     * @param location the location of spawn the enemy
     */
    @Override
    public void spawn(Location location){
        if (Math.random() * 100 <= 30 && !location.containsAnActor()) {
            location.addActor(new RedWolf());
        }
    }
}

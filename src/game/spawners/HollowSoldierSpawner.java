package game.spawners;

import game.actors.enemies.HollowSoldier;

public class HollowSoldierSpawner implements Spawner{
    /**
     * Spawner for generating instances of the Hollow Soldier.
     */
    @Override
    public HollowSoldier spawn() {
        return new HollowSoldier();
    }
}

package game.spawners;

import game.actors.enemies.HollowSoldier;

/**
 * Spawner for generating instances of the Hollow Soldier.
 */
public class HollowSoldierSpawner extends Spawner{
    public HollowSoldierSpawner(){
        super(10);
    }
    @Override
    public HollowSoldier createEnemy() {
        return new HollowSoldier();
    }
}

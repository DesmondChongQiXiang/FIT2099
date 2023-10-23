package game.grounds.environments;

import game.actors.enemies.HollowSoldier;
import game.spawners.HollowSoldierSpawner;

/**
 * The BurialGroundGraveyard class represents a type of ground in the burial ground environment where Hollow Soldier enemies can spawn.
 * It extends the VillageEnemySpawnableGround class and provides functionality to control the spawning of Hollow Soldier enemies.
 *
 * This class sets the specific character representation and spawn rate for Hollow Soldier spawning in the burial ground graveyard.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <H> The type of Hollow Soldier enemy that can spawn in this type of ground.
 * @see EnemySpawnableGround
 */
public class HollowSoldierGraveyard<H extends HollowSoldier> extends EnemySpawnableGround<H> {

    /**
     * Constructor to create a BurialGroundGraveyard instance.
     *
     * @param hollowSoldierSpawner The spawner for Hollow Soldier enemies associated with this type of ground.
     */
    public HollowSoldierGraveyard(HollowSoldierSpawner hollowSoldierSpawner){
        super('n', 10, hollowSoldierSpawner);
    }
}


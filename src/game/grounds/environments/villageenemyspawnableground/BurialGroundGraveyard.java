package game.grounds.environments.villageenemyspawnableground;

import game.actors.enemies.villageenemy.HollowSoldier;
import game.spawners.Spawner;

/**
 * The BurialGroundGraveyard class represents a type of ground in the burial ground environment where Hollow Soldier enemies can spawn.
 * It extends the VillageEnemySpawnableGround class and provides functionality to control the spawning of Hollow Soldier enemies.
 *
 * This class sets the specific character representation and spawn rate for Hollow Soldier spawning in the burial ground graveyard.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <H> The type of Hollow Soldier enemy that can spawn in this type of ground.
 * @see VillageEnemySpawnableGround
 */
public class BurialGroundGraveyard<H extends HollowSoldier> extends VillageEnemySpawnableGround<H> {

    /**
     * Constructor to create a BurialGroundGraveyard instance.
     *
     * @param hollowSoldierSpawner The spawner for Hollow Soldier enemies associated with this type of ground.
     */
    public BurialGroundGraveyard(Spawner<H> hollowSoldierSpawner){
        super('n', 10, hollowSoldierSpawner);
    }
}


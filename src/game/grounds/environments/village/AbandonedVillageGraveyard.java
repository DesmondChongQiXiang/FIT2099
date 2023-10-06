package game.grounds.environments.village;

import game.actors.enemies.villageenemy.WanderingUndead;
import game.spawners.Spawner;

/**
 * The AbandonedVillageGraveyard class represents a type of ground in the abandoned village environment where Wandering Undead enemies can spawn.
 * It extends the VillageEnemySpawnableGround class and provides functionality to control the spawning of Wandering Undead enemies.
 *
 * This class sets the specific character representation and spawn rate for Wandering Undead spawning in the abandoned village graveyard.
 *
 * @author : MA_AppliedSession1_Group7
 *
 * @param <W> The type of Wandering Undead enemy that can spawn in this type of ground.
 * @see VillageEnemySpawnableGround
 */
public class AbandonedVillageGraveyard<W extends WanderingUndead> extends VillageEnemySpawnableGround<W> {

    /**
     * Constructor to create an AbandonedVillageGraveyard instance.
     *
     * @param wanderingUndeadSpawner The spawner for Wandering Undead enemies associated with this type of ground.
     */
    public AbandonedVillageGraveyard(Spawner<W> wanderingUndeadSpawner){
        super('n', 25, wanderingUndeadSpawner);
    }
}
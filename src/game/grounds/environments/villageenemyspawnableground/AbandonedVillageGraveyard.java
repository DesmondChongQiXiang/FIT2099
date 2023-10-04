package game.grounds.environments.villageenemyspawnableground;

import game.actors.enemies.villageenemy.WanderingUndead;
import game.spawners.Spawner;

public class AbandonedVillageGraveyard<W extends WanderingUndead> extends VillageEnemySpawnableGround<W> {

    /**
     * Constructor.
     */
    public AbandonedVillageGraveyard(Spawner<W> wanderingUndeadSpawner){
        super('n',25,wanderingUndeadSpawner);
    }
}

package game.grounds.environments.villageenemyspawnableground;

import game.spawners.villageenemyspawner.WanderingUndeadSpawner;


public class AbandonedVillageGraveyard extends VillageEnemySpawnableGround {

    /**
     * Constructor.
     */
    public AbandonedVillageGraveyard(WanderingUndeadSpawner wanderingUndeadSpawner){
        super('n',25,wanderingUndeadSpawner);
    }


}

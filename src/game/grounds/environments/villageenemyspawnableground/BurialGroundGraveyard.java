package game.grounds.environments.villageenemyspawnableground;

import game.spawners.villageenemyspawner.HollowSoldierSpawner;
import game.spawners.villageenemyspawner.VillageEnemySpawner;

public class BurialGroundGraveyard extends VillageEnemySpawnableGround{
    public BurialGroundGraveyard(HollowSoldierSpawner hollowSoldierSpawner){
        super('n',10,hollowSoldierSpawner);
    }
}

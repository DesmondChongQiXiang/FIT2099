package game.grounds.environments.villageenemyspawnableground;

import game.actors.enemies.forestenemy.ForestEnemy;
import game.actors.enemies.villageenemy.HollowSoldier;
import game.actors.enemies.villageenemy.VillageEnemy;
import game.spawners.Spawner;

public class BurialGroundGraveyard<H extends HollowSoldier> extends VillageEnemySpawnableGround<H>{
    public BurialGroundGraveyard(Spawner<H> hollowSoldierSpawner){
        super('n',10,hollowSoldierSpawner);
    }
}

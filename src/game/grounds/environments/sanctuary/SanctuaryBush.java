package game.grounds.environments.sanctuary;


import game.actors.enemies.sanctuaryenemy.LivingBranch;
import game.spawners.Spawner;

public class SanctuaryBush<L extends LivingBranch> extends SanctuaryEnemySpawnableGround<L>{

    public SanctuaryBush(Spawner<L> livingBranchSpawner) {
        super('m', 90, livingBranchSpawner);
    }
}

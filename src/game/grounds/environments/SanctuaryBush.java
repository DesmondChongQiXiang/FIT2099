package game.grounds.environments;


import game.actors.enemies.LivingBranch;
import game.spawners.Spawner;

public class SanctuaryBush<L extends LivingBranch> extends EnemySpawnableGround<L> {

    public SanctuaryBush(Spawner<L> livingBranchSpawner) {
        super('m', 90, livingBranchSpawner);
    }
}

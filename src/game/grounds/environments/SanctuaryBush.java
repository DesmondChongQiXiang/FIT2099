package game.grounds.environments;


import game.actors.enemies.LivingBranch;
import game.spawners.LivingBranchSpawner;

public class SanctuaryBush<L extends LivingBranch> extends EnemySpawnableGround<L> {

    public SanctuaryBush(LivingBranchSpawner livingBranchSpawner) {
        super('m', 90, livingBranchSpawner);
    }
}

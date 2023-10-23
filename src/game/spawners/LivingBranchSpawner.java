package game.spawners;

import game.actors.enemies.LivingBranch;

/**
 * Spawner for generating instances of the LivingBranch.
 */
public class LivingBranchSpawner extends Spawner{
    public LivingBranchSpawner(){
        super(90);
    }
    @Override
    public LivingBranch createEnemy() {
        return new LivingBranch();
    }
}

package game.spawners;

import game.actors.enemies.LivingBranch;

public class LivingBranchSpawner implements Spawner{
    /**
     * Spawner for generating instances of the LivingBranch.
     */
        @Override
        public LivingBranch spawn() {
            return new LivingBranch();
        }
}

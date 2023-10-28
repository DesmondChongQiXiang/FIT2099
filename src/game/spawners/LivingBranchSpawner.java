package game.spawners;

import game.actors.enemies.LivingBranch;

import java.util.ArrayList;

/**
 * The `LivingBranchSpawner` class is responsible for spawning instances of the LivingBranch enemy actor at specific
 * locations within the game world.
 */
public class LivingBranchSpawner extends Spawner {
    /**
     * Constructs a `LivingBranchSpawner` with an empty list of enemy actors.
     */
    public LivingBranchSpawner() {
        super(90);
    }

    @Override
    public LivingBranch createEnemy() {
        return new LivingBranch();
    }
}


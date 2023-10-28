package game.spawners;

import game.actors.enemies.LivingBranch;

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

    /**
     * Creates and returns a new instance of the LivingBranch enemy actor.
     *
     * @return The LivingBranch enemy actor created by this spawner.
     */
    @Override
    public LivingBranch createEnemy() {
        return new LivingBranch();
    }
}


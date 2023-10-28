package game.spawners;

import game.actors.enemies.EldentreeGuardian;

/**
 * The `EldentreeGuardianSpawner` class is responsible for spawning instances of the EldentreeGuardian enemy actor
 * at specific locations within the game world.
 */
public class EldentreeGuardianSpawner extends Spawner {
    /**
     * Constructs an `EldentreeGuardianSpawner` with an empty list of enemy actors.
     */
    public EldentreeGuardianSpawner() {
        super(20);
    }

    @Override
    public EldentreeGuardian createEnemy() {
        return new EldentreeGuardian();
    }
}

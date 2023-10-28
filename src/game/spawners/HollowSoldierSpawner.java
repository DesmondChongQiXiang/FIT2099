package game.spawners;

import game.actors.enemies.HollowSoldier;

/**
 * The `HollowSoldierSpawner` class is responsible for spawning instances of the Hollow Soldier enemy actor
 * at specific locations within the game world.
 */
public class HollowSoldierSpawner extends Spawner {
    /**
     * Constructs a `HollowSoldierSpawner` with an empty list of enemy actors.
     */
    public HollowSoldierSpawner() {
        super(10);
    }

    /**
     * Creates and returns a new instance of the HollowSoldier enemy actor.
     *
     * @return The HollowSoldier enemy actor created by this spawner.
     */
    @Override
    public HollowSoldier createEnemy() {
        return new HollowSoldier();
    }
}


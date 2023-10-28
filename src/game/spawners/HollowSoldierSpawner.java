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

    @Override
    public HollowSoldier createEnemy() {
        return new HollowSoldier();
    }
}


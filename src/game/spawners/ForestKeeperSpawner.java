package game.spawners;

import game.actors.enemies.ForestKeeper;

public class ForestKeeperSpawner implements Spawner{
    /**
     * Spawner for generating instances of the ForestKeeper.
     */
        @Override
        public ForestKeeper spawn() {
            return new ForestKeeper();
        }
}

package game.spawners;

import game.actors.enemies.EldentreeGuardian;

public class EldentreeGuardianSpawner implements Spawner{
    /**
     * Spawner for generating instances of the EldentreeGuardian.
     */
        @Override
        public EldentreeGuardian spawn() {
            return new EldentreeGuardian();
        }
}

package game.grounds.environments;

import game.actors.enemies.EldentreeGuardian;
import game.spawners.EldentreeGuardianSpawner;

public class SanctuaryHut<E extends EldentreeGuardian> extends EnemySpawnableGround<E> {

    public SanctuaryHut(EldentreeGuardianSpawner eldentreeGuardianSpawner) {
        super('h', 20, eldentreeGuardianSpawner);
    }

}


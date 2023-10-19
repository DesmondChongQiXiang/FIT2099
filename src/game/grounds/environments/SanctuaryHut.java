package game.grounds.environments;

import game.actors.enemies.EldentreeGuardian;
import game.spawners.Spawner;

public class SanctuaryHut<E extends EldentreeGuardian> extends EnemySpawnableGround<E> {

    public SanctuaryHut(Spawner<E> eldentreeGuardianSpawner) {
        super('h', 20, eldentreeGuardianSpawner);
    }

}


package game.grounds.environments.sanctuary;

import game.actors.enemies.sanctuaryenemy.EldentreeGuardian;
import game.spawners.Spawner;

public class SanctuaryHut<E extends EldentreeGuardian> extends SanctuaryEnemySpawnableGround<E> {

    public SanctuaryHut(Spawner<E> eldentreeGuardianSpawner) {
        super('h', 20, eldentreeGuardianSpawner);
    }

}


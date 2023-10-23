package game.spawners;

import game.actors.enemies.EldentreeGuardian;

/**
 * Spawner for generating instances of the EldentreeGuardian.
 */
public class EldentreeGuardianSpawner extends Spawner{

    public EldentreeGuardianSpawner(){
        super(20);
    }
    @Override
    public EldentreeGuardian createEnemy() {
        return new EldentreeGuardian();
    }
}

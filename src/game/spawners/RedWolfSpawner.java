package game.spawners;

import game.actors.enemies.RedWolf;

public class RedWolfSpawner implements Spawner{
    /**
     * Spawner for generating instances of the Red Wolf.
     */
    @Override
    public RedWolf spawn() {
        return new RedWolf();
    }
}
